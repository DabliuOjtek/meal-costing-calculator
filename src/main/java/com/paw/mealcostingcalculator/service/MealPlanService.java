package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.dtos.MealPlanDTO;
import com.paw.mealcostingcalculator.dtos.detailsDTOS.MealPlanDetailsDTO;
import com.paw.mealcostingcalculator.dtos.saveDTOS.MealPlanSaveDTO;
import com.paw.mealcostingcalculator.mapper.MealPlanMapper;
import com.paw.mealcostingcalculator.model.MealPlanEntity;
import com.paw.mealcostingcalculator.model.UserEntity;
import com.paw.mealcostingcalculator.repository.MealPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealPlanService {

    private final MealPlanRepository mealPlanRepository;
    private final UserService userService;

    public List<MealPlanDTO> getAllMealsPlan(UserDetailsImpl userDetails) {
        UserEntity user = userService.getUserByUsername(userDetails.getUsername());
        return user.getMealPlans().stream()
                .map(MealPlanMapper::mapToMealPlanDTO)
                .collect(Collectors.toList());
    }

    public MealPlanDetailsDTO getParticularMealPlanDay(LocalDate date, UserDetailsImpl userDetails) {
        Set<MealPlanEntity> userMealPlan = getUserMealPlanSet(userDetails);
        MealPlanEntity mealPlanEntity = getMealPlanByDate(date);

        if (userMealPlan.contains(mealPlanEntity)) {
            return MealPlanMapper.mapToMealPlanDetailsDTO(mealPlanEntity);
        } else {
            throw new NoSuchElementException("The meal plan you are looking for, does not belong to the user");
        }
    }

    @Transactional
    public void addMealPlan(MealPlanSaveDTO mealPlanSaveDTO, UserDetailsImpl userDetails) {
        MealPlanEntity mealPlanEntity = MealPlanMapper.mapToMealPlanSaveDTO(mealPlanSaveDTO);

        if (mealPlanEntity.getDate() != null) {
            UserEntity user = userService.getUserByUsername(userDetails.getUsername());
            mealPlanEntity.setUserEntity(user);
            mealPlanEntity.setCost(BigDecimal.ZERO);

            mealPlanRepository.save(mealPlanEntity);
        } else {
            throw new IllegalArgumentException("Parameter cannot be empty");
        }
    }

    public void deleteParticularMealPlanDay(LocalDate date, UserDetailsImpl userDetails) {
        Set<MealPlanEntity> userMealPlan = getUserMealPlanSet(userDetails);
        MealPlanEntity mealPlanEntity = getMealPlanByDate(date);

        if (userMealPlan.contains(mealPlanEntity)) {
            mealPlanRepository.delete(mealPlanEntity);
        } else {
            throw new NoSuchElementException("The meal plan you are looking for, does not belong to the user");
        }
    }

    @Transactional
    public void updateMealPlan(MealPlanDTO mealPlan) {
        LocalDate mealPlanDate = mealPlan.getDate();
        MealPlanEntity mealPlanEntity = getMealPlanByDate(mealPlanDate);

        if (mealPlanEntity.getDate() != null) {
            mealPlanEntity.setDate(mealPlan.getDate());
        } else {
            throw new IllegalArgumentException("Parameter cannot be empty");
        }
    }

    public void updateMealPlanCost(Integer id, BigDecimal newMealCost) {
        MealPlanEntity mealPlanEntity = getMealPlanById(id);
        BigDecimal currentCost = mealPlanEntity.getCost();
        BigDecimal newCost = currentCost.add(newMealCost);

        mealPlanEntity.setCost(newCost);
        mealPlanRepository.save(mealPlanEntity);
    }

    public LocalDate getMealPlanDate(Integer id) {
        MealPlanEntity mealPlanEntity = getMealPlanById(id);
        return mealPlanEntity.getDate();
    }

    public Set<MealPlanEntity> getUserMealPlanSet(UserDetailsImpl userDetails) {
        UserEntity user = userService.getUserByUsername(userDetails.getUsername());
        return user.getMealPlans();
    }

    private MealPlanEntity getMealPlanById(Integer id) {
        return mealPlanRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cannot find any meal plan from given id"));
    }

    private MealPlanEntity getMealPlanByDate(LocalDate date) {
        return mealPlanRepository.findByDate(date);
    }

}
