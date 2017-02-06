/**
  * @author Vitaliy_Zinchenko
  */
class Test {
  def main(args: Array[String]): Unit = {

    class XapGrid {
      def deployXap() = {
        println("deployXap")
      }
    }

    class IeGrid() extends XapGrid {
      def deployIe() = {
        println("deployIe")
      }
    }

    val grid = new IeGrid()

    grid.deployXap()
    grid.deployIe()


//    class IeGrid(g: XapGrid) {
//
//    }
  }


//  def ttt(x: XapGrid.type) = {
//
//  }
}
