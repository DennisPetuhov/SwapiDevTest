package com.example.swapidevtest.DOMAIN.UseCase.StarShipSearchUseCase

import com.example.swapidevtest.DATA.Repository.Repository
import com.example.swapidevtest.DOMAIN.model.StarShips
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StarShipSearchUseCase @Inject constructor(val repository: Repository) {
    fun starShipSearchUseCase(qwerty: String): Flow<List<StarShips>> {
     return   repository.getShipSearch(qwerty)
    }
}