# How to run
Create a new scratch file and copy this file contents into it
(I'm not sure how to import scratch files into the workspace)

![image](https://user-images.githubusercontent.com/45592851/112501530-ff6c6400-8d91-11eb-832c-1c370264d267.png)

* Orders are squares with letters
* Drivers are circles with numbers
* Go to the bottom of the file and call doScoring with one of the available datasets (listed below).
* The output will list a set of orders and which driver they are assigned to.
* Compare this to the diagrams to verify that they make sense.
* -1 means an order has not been allocated

Example output for Simple Demo :
```
A -> 2 Order A goes to driver 2 (distance of 70)
B -> 6 Order B goes to driver 6 (distance of 90)
C -> 4 Order C goes to driver 4 (distance of 70)
```

# Datasets

## Simple Demo
scoredOrdersSimple
3 orders
6 drivers
each order has one driver which is especially close

Distances to order A (expect driver 2 to get it)
![image](https://user-images.githubusercontent.com/45592851/112496895-c9c57c00-8d8d-11eb-97c5-eb7427786f6c.png)

Distances to order B (expect driver 6 to get it)
![image](https://user-images.githubusercontent.com/45592851/112497328-2cb71300-8d8e-11eb-9294-6bae8d881d25.png)

Distances to order C (expect driver 4 to get it)
![image](https://user-images.githubusercontent.com/45592851/112497394-3d678900-8d8e-11eb-926a-6433deeb8374.png)

## Oddly Positioned
scoredOrdersOddPosition
5 orders
5 drivers
Driver 3 should get order C, might not if the orders are greedilly assigned
![image](https://user-images.githubusercontent.com/45592851/112497505-5c661b00-8d8e-11eb-8bdc-1bfabe72643f.png)

## More orders than drivers
scoredOrdersNotEnoughDrivers
6 orders
5 drivers

Order C wont get assigned
![image](https://user-images.githubusercontent.com/45592851/112497738-8d465000-8d8e-11eb-9c3b-cabcab2c4bb0.png)

## More drivers than orders
scoredOrdersExtraDrivers
7 orders
9 drivers

Some orders have more than one driver nearby (but one is always slightly closer)
![image](https://user-images.githubusercontent.com/45592851/112498069-da2a2680-8d8e-11eb-8539-f8db3e12242a.png)

# How to validate dataset using Gimp
https://www.gimp.org/

![image](https://user-images.githubusercontent.com/45592851/112500899-748b6980-8d91-11eb-969a-8361c8ee0d39.png)


