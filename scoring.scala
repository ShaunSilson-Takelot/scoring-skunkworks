


case class ScoreableOrder (
  orderId: String
)

case class DriverScore(
  driverId: Long,
  distance: Double,
  score: Long
)

case class ScoredOrder (
  order: ScoreableOrder,
  scores: List[DriverScore]
)

case class AllocatedOrder(
  driverId: Long,
  score: Long,
  distance: Double,
  scoredOrder: ScoredOrder
)

/* ############################################################################ */

val scoredOrdersSimple =
  List(
    ScoredOrder(
      ScoreableOrder("A"),
      List(
        DriverScore(1, 120, 10),
        DriverScore(2,  70, 10),
        DriverScore(3, 250, 10),
        DriverScore(4, 450, 10),
        DriverScore(5, 250, 10),
        DriverScore(6, 400, 10),
        DriverScore(7, 200, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("B"),
      List(
        DriverScore(1, 520, 10),
        DriverScore(2, 340, 10),
        DriverScore(3, 520, 10),
        DriverScore(4, 570, 10),
        DriverScore(5, 300, 10),
        DriverScore(6,  90, 10),
        DriverScore(7, 190, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("C"),
      List(
        DriverScore(1, 430, 10),
        DriverScore(2, 590, 10),
        DriverScore(3, 270, 10),
        DriverScore(4,  70, 10),
        DriverScore(5, 190, 10),
        DriverScore(6, 450, 10),
        DriverScore(7, 630, 10)
      )
    )
  )



// Map(2 -> ListBuffer(B), 1 -> ListBuffer(A), 3 -> ListBuffer(C, D))
// Map(D -> 3, A -> 1, C -> 3, B -> 2)

/*
000000000111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999
123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789
A                       B                        C                                  D
   1 2                                        3
*/

val scoredOrdersNotEnoughDriversLinear =
  List(
    ScoredOrder(
      ScoreableOrder("A"),
      List(
        DriverScore(1, Math.abs(4-1) , 10),
        DriverScore(2, Math.abs(6-1) , 10),
        DriverScore(3, Math.abs(47-1), 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("B"),
      List(
        DriverScore(1, Math.abs(4-25) , 10 ),
        DriverScore(2, Math.abs(6-25) , 10 ),
        DriverScore(3, Math.abs(47-25), 10 )
      )
    ),
    ScoredOrder(
      ScoreableOrder("C"),
      List(
        DriverScore(1, Math.abs(4-50) , 10 ),
        DriverScore(2, Math.abs(6-50) , 10 ),
        DriverScore(3, Math.abs(47-50), 10 )
      )
    ),
    ScoredOrder(
      ScoreableOrder("D"),
      List(
        DriverScore(1, Math.abs(4-85) , 10 ),
        DriverScore(2, Math.abs(6-85) , 10 ),
        DriverScore(3, Math.abs(47-85), 10 )
      )
    )
  )

/* ############################################################################ */

val scoredOrdersOddPosition =
  List(
    ScoredOrder(
      ScoreableOrder("A"),
      List(
        DriverScore(1, 130, 10), // 1
        DriverScore(2, 300, 10),
        DriverScore(3, 365, 10),
        DriverScore(4, 750, 10),
        DriverScore(5, 630, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("B"),
      List(
        DriverScore(1, 470, 10),
        DriverScore(2, 100, 10), // 2
        DriverScore(3, 380, 10),
        DriverScore(4, 700, 10),
        DriverScore(5, 400, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("C"),
      List(
        DriverScore(1, 500, 10),
        DriverScore(2, 630, 10),
        DriverScore(3, 350, 10), // 3
        DriverScore(4, 330, 10),
        DriverScore(5, 570, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("D"),
      List(
        DriverScore(1, 800, 10),
        DriverScore(2, 680, 10),
        DriverScore(3, 460, 10),
        DriverScore(4, 120, 10), // 4
        DriverScore(5, 370, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("E"),
      List(
        DriverScore(1, 700, 10),
        DriverScore(2, 400, 10),
        DriverScore(3, 430, 10),
        DriverScore(4, 480, 10),
        DriverScore(5, 120, 10) // 5
      )
    )
  )

/* ############################################################################ */

val scoredOrdersNotEnoughDrivers =
  List(
    ScoredOrder(
      ScoreableOrder("A"),
      List(
        DriverScore(1, 130, 10), // 1
        DriverScore(2, 300, 10),
        DriverScore(3, 365, 10),
        DriverScore(4, 750, 10),
        DriverScore(5, 630, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("B"),
      List(
        DriverScore(1, 470, 10),
        DriverScore(2, 100, 10), // 2
        DriverScore(3, 380, 10),
        DriverScore(4, 700, 10),
        DriverScore(5, 400, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("C"),
      List(
        DriverScore(1, 500, 10),
        DriverScore(2, 630, 10),
        DriverScore(3, 350, 10), // 3
        DriverScore(4, 330, 10),
        DriverScore(5, 570, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("D"),
      List(
        DriverScore(1, 800, 10),
        DriverScore(2, 680, 10),
        DriverScore(3, 460, 10),
        DriverScore(4, 120, 10), // 4
        DriverScore(5, 370, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("E"),
      List(
        DriverScore(1, 700, 10),
        DriverScore(2, 400, 10),
        DriverScore(3, 430, 10),
        DriverScore(4, 480, 10),
        DriverScore(5, 120, 10) // 5
      )
    ),
    ScoredOrder(
      ScoreableOrder("F"),
      List(
        DriverScore(1, 160, 10),
        DriverScore(2, 380, 10),
        DriverScore(3, 220, 10),
        DriverScore(4, 540, 10),
        DriverScore(5, 550, 10)
      )
    ),
    ScoredOrder(
      ScoreableOrder("G"),
      List(
        DriverScore(1, 420, 10),
        DriverScore(2, 320, 10),
        DriverScore(3,  90, 10),
        DriverScore(4, 310, 10),
        DriverScore(5, 260, 10)
      )
    )
  )

/* ############################################################################ */

val scoredOrdersExtraDrivers =
  List(
    ScoredOrder(
      ScoreableOrder("A"),
      List(
        DriverScore(1, 130, 10), // 1
        DriverScore(2, 300, 10),
        DriverScore(3, 365, 10),
        DriverScore(4, 750, 10),
        DriverScore(5, 630, 10),
        DriverScore(6, 590, 10),
        DriverScore(7, 760, 10),
        DriverScore(8, 320, 10),
        DriverScore(9, 430, 10),
      )
    ),
    ScoredOrder(
      ScoreableOrder("B"),
      List(
        DriverScore(1, 470, 10),
        DriverScore(2, 100, 10), // 2
        DriverScore(3, 380, 10),
        DriverScore(4, 700, 10),
        DriverScore(5, 400, 10),
        DriverScore(6, 750, 10),
        DriverScore(7, 660, 10),
        DriverScore(8, 500, 10),
        DriverScore(9, 150, 10),
      )
    ),
    ScoredOrder(
      ScoreableOrder("C"),
      List(
        DriverScore(1, 500, 10),
        DriverScore(2, 630, 10),
        DriverScore(3, 350, 10), // 3
        DriverScore(4, 330, 10),
        DriverScore(5, 570, 10),
        DriverScore(6,  80, 10),
        DriverScore(7, 400, 10),
        DriverScore(8, 290, 10),
        DriverScore(9, 620, 10),
      )
    ),
    ScoredOrder(
      ScoreableOrder("D"),
      List(
        DriverScore(1, 800, 10),
        DriverScore(2, 680, 10),
        DriverScore(3, 460, 10),
        DriverScore(4, 120, 10), // 4
        DriverScore(5, 370, 10),
        DriverScore(6, 560, 10),
        DriverScore(7, 150, 10),
        DriverScore(8, 640, 10),
        DriverScore(9, 650, 10),
      )
    ),
    ScoredOrder(
      ScoreableOrder("E"),
      List(
        DriverScore(1, 700, 10),
        DriverScore(2, 400, 10),
        DriverScore(3, 430, 10),
        DriverScore(4, 480, 10),
        DriverScore(5, 120, 10), // 5
        DriverScore(6, 740, 10),
        DriverScore(7, 420, 10),
        DriverScore(8, 610, 10),
        DriverScore(9, 280, 10),
      )
    ),
    ScoredOrder(
      ScoreableOrder("F"),
      List(
        DriverScore(1, 160, 10),
        DriverScore(2, 380, 10),
        DriverScore(3, 220, 10),
        DriverScore(4, 540, 10),
        DriverScore(5, 550, 10),
        DriverScore(6, 360, 10),
        DriverScore(7, 530, 10),
        DriverScore(8,  90, 10),
        DriverScore(9, 360, 10),
      )
    ),
    ScoredOrder(
      ScoreableOrder("G"),
      List(
        DriverScore(1, 420, 10),
        DriverScore(2, 320, 10),
        DriverScore(3,  90, 10),
        DriverScore(4, 310, 10),
        DriverScore(5, 260, 10),
        DriverScore(6, 390, 10),
        DriverScore(7, 290, 10),
        DriverScore(8, 270, 10),
        DriverScore(9, 290, 10),
      )
    )
  )

/* ############################################################################ */

def allocateToHighest(
  scoredOrders: List[ScoredOrder],
  excludedDrivers: List[Long]
): List[AllocatedOrder] = scoredOrders.map{ scoredOrder =>

  val bestScore =
    scoredOrder
      .scores
      .filter( sc => !excludedDrivers.contains(sc.driverId)  )
      .sortBy( _.distance )
      .headOption

  bestScore match {
    case None => {
      // This order cannot be assigned
      AllocatedOrder(
        -1,
        -1,
        -1,
        scoredOrder
      )
    }
    case Some(bs) =>  {
      AllocatedOrder(
        bs.driverId,
        bs.score,
        bs.distance,
        scoredOrder
      )
    }
  }

}

def doScoring(
  scoredOrders: List[ScoredOrder],
  alreadyAllocatedDriverIds: List[Long]
): List[AllocatedOrder] = {

  if(scoredOrders.isEmpty){
    List.empty
  } else {

    val assignedOrders =
      allocateToHighest(
        scoredOrders,
        alreadyAllocatedDriverIds
      )

    val allocatedDriverIds: List[Long] =
      (
        alreadyAllocatedDriverIds :::
        assignedOrders.map( _.driverId )
      ).distinct

    allocatedDriverIds.flatMap{ id =>

      val ordersForThisDriver =
        assignedOrders
          .filter( a => a.driverId == id )
          .sortBy( _.score  )

      val bestOrderForThisDriver   = if(ordersForThisDriver.nonEmpty){ List(ordersForThisDriver.head) } else { List() }
      val otherOrdersForThisDriver = if(ordersForThisDriver.nonEmpty){      ordersForThisDriver.tail  } else { List() }

      bestOrderForThisDriver :::
      doScoring(
        otherOrdersForThisDriver.map(_.scoredOrder),
        allocatedDriverIds
      )
    }
  }
}

val datasets = List(
  scoredOrdersSimple,
  scoredOrdersOddPosition,
  scoredOrdersNotEnoughDriversLinear,
  scoredOrdersNotEnoughDrivers,
  scoredOrdersExtraDrivers
)

val results = doScoring(scoredOrdersSimple, List())

val out =
  results.map{ r =>
    r.scoredOrder.order.orderId + " -> " + r.driverId
  }

println(out.mkString("\n"))



