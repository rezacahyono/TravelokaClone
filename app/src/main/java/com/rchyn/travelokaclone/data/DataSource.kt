package com.rchyn.travelokaclone.data

import com.rchyn.travelokaclone.R
import com.rchyn.travelokaclone.domain.model.Cities
import com.rchyn.travelokaclone.domain.model.Hotel
import com.rchyn.travelokaclone.domain.model.Menu
import com.rchyn.travelokaclone.domain.model.Promo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object DataSource {
    private val listTitleMenuFirst = listOf(
        R.string.flight,
        R.string.hotel,
        R.string.trains,
        R.string.xperience,
        R.string.holiday,
        R.string.bus,
        R.string.airport_transit,
        R.string.car,
        R.string.flight_hotel,
        R.string.insurance
    )
    private val listTitleMenuSecond = listOf(
        R.string.healt_care,
        R.string.eat,
        R.string.top_up_data_package,
        R.string.price_alert,
        R.string.jr_pass,
        R.string.airport_train,
        R.string.pay_leter,
        R.string.buy_now_stay_leter,
        R.string.flight_status,
        R.string.budget_planning
    )

    private val listIconMenuFirst = listOf(
        R.drawable.ic_menu_flight,
        R.drawable.ic_menu_hotel,
        R.drawable.ic_menu_trains,
        R.drawable.ic_menu_xperience,
        R.drawable.ic_menu_holiday,
        R.drawable.ic_menu_bus,
        R.drawable.ic_menu_airport_transit,
        R.drawable.ic_menu_car,
        R.drawable.ic_menu_flight_hotel,
        R.drawable.ic_menu_insurance
    )

    private val listIconMenuSecond = listOf(
        R.drawable.ic_menu_healtcare,
        R.drawable.ic_menu_eat,
        R.drawable.ic_menu_top_up_data_package,
        R.drawable.ic_menu_price_alert,
        R.drawable.ic_menu_jr_pass,
        R.drawable.ic_menu_airport_train,
        R.drawable.ic_menu_payleter,
        R.drawable.ic_menu_buy_now_stay_leter,
        R.drawable.ic_menu_fligth_status,
        R.drawable.ic_menu_budget_planner
    )

    val listMenuFirst: Flow<List<Menu>> = flow {
        val data: MutableList<Menu> = mutableListOf()
        for (i in listTitleMenuFirst.indices) {
            val menu = Menu(
                title = listTitleMenuFirst[i],
                icon = listIconMenuFirst[i]
            )
            data.add(menu)
        }
        emit(data)
    }

    val listMenuSecond: Flow<List<Menu>> = flow {
        val data: MutableList<Menu> = mutableListOf()
        for (i in listTitleMenuSecond.indices) {
            val menu = Menu(
                title = listTitleMenuSecond[i],
                icon = listIconMenuSecond[i]
            )
            data.add(menu)
        }
        emit(data)
    }

    private val listImagePromoLandscape = listOf(
        R.drawable.banner_promo_1,
        R.drawable.banner_promo_2,
        R.drawable.banner_promo_3,
        R.drawable.banner_promo_4,
        R.drawable.banner_promo_5,
    )

    val listPromoLandscape: Flow<List<Int>> = flow {
        val data: MutableList<Int> = mutableListOf()
        listImagePromoLandscape.forEach {
            data.add(it)
        }
        emit(data)
    }

    private val listImageHotel = listOf(
        R.drawable.hotel1,
        R.drawable.hotel2,
        R.drawable.hotel3,
        R.drawable.hotel4,
        R.drawable.hotel5,
        R.drawable.hotel6,
        R.drawable.hotel7,
        R.drawable.hotel8,
        R.drawable.hotel9,
        R.drawable.hotel10,
    )

    private val listUrbanVillage = listOf(
        R.string.urban_village_1,
        R.string.urban_village_2,
        R.string.urban_village_3,
        R.string.urban_village_4,
        R.string.urban_village_5,
        R.string.urban_village_6,
        R.string.urban_village_7,
        R.string.urban_village_8,
        R.string.urban_village_9,
        R.string.urban_village_10,
    )

    private val listTitleHotel = listOf(
        R.string.title_hotel_1,
        R.string.title_hotel_2,
        R.string.title_hotel_3,
        R.string.title_hotel_4,
        R.string.title_hotel_5,
        R.string.title_hotel_6,
        R.string.title_hotel_7,
        R.string.title_hotel_8,
        R.string.title_hotel_9,
        R.string.title_hotel_10,
    )

    private val listSale = listOf(
        R.string.sale_1,
        R.string.sale_2,
        R.string.sale_3,
        R.string.sale_4,
        R.string.sale_5,
        R.string.sale_6,
        R.string.sale_7,
        R.string.sale_8,
        R.string.sale_9,
        R.string.sale_10,
    )

    private val listPriceOriginal = listOf(
        R.string.price_original_1,
        R.string.price_original_2,
        R.string.price_original_3,
        R.string.price_original_4,
        R.string.price_original_5,
        R.string.price_original_6,
        R.string.price_original_7,
        R.string.price_original_8,
        R.string.price_original_9,
        R.string.price_original_10,
    )

    private val listPriceResult = listOf(
        R.string.price_result_1,
        R.string.price_result_2,
        R.string.price_result_3,
        R.string.price_result_4,
        R.string.price_result_5,
        R.string.price_result_6,
        R.string.price_result_7,
        R.string.price_result_8,
        R.string.price_result_9,
        R.string.price_result_10,
    )

    val listHotel: Flow<List<Hotel>> = flow {
        val data: MutableList<Hotel> = mutableListOf()
        listTitleHotel.take(6).forEachIndexed { i, title ->
            val hotel = Hotel(
                image = listImageHotel[i],
                urbanVillage = listUrbanVillage[i],
                title = title,
                sale = listSale[i],
                priceOriginal = listPriceOriginal[i],
                priceResult = listPriceResult[i],
                cities = Cities.JAKARTA
            )
            data.add(hotel)
        }
        emit(data)
    }

    val listHotelByCities: (q: Cities) -> Flow<List<Hotel>> = { q ->
        flow {
            val data: MutableList<Hotel> = mutableListOf()
            listTitleHotel.forEachIndexed { i, title ->
                val hotel = Hotel(
                    image = listImageHotel[i],
                    urbanVillage = listUrbanVillage[i],
                    title = title,
                    sale = listSale[i],
                    priceOriginal = listPriceOriginal[i],
                    priceResult = listPriceResult[i],
                    cities = if (i > 5) Cities.BALI else Cities.JAKARTA
                )
                data.add(hotel)
            }
            emit(data.filter { it.cities == q })
        }
    }


    private val listTitlePromo = listOf(
        R.string.title_promo_1,
        R.string.title_promo_2,
        R.string.title_promo_3,
    )

    private val listPeriodPromo = listOf(
        R.string.period_promo_1,
        R.string.period_promo_2,
        R.string.period_promo_3,
    )

    private val listImagePromo = listOf(
        R.drawable.promo1,
        R.drawable.promo2,
        R.drawable.promo3,
    )

    val listPromo: Flow<List<Promo>> = flow {
        val data: MutableList<Promo> = mutableListOf()
        listTitlePromo.forEachIndexed { index, title ->
            val promo = Promo(
                image = listImagePromo[index],
                title = title,
                period = listPeriodPromo[index]
            )
            data.add(promo)
        }
        emit(data)
    }
}