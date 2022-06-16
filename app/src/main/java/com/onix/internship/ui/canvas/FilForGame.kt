package com.onix.internship.ui.canvas

enum class Cell {
    PLAYER_1,
    COMPUTER,
    EMPTY
}
class FilForGame(row:Int = 3, private val columns: Int = 3) {

    private val cells  = Array(row){Array(columns){Cell.EMPTY} }

    fun getCell(row: Int,columns: Int):Cell{

        return cells[row][columns]
    }

    fun setCell(row: Int, columns: Int, cell: Cell): Cell {

        return cell.also { cells[row][columns] = it }
    }

}
