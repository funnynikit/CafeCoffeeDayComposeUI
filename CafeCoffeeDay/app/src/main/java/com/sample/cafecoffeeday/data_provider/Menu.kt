package com.sample.cafecoffeeday.data_provider

data class Menu(val id:Int,val title:String)

val menuList = listOf<Menu>(Menu(1,"All"),Menu(2,"Coffee"),Menu(3,"Tea"),Menu(4,"Drinks"),Menu(5,"Beer"),Menu(6,"Wine"))