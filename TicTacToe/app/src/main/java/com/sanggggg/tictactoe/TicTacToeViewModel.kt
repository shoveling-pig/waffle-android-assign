package com.sanggggg.tictactoe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

@Suppress("PrivatePropertyName")
class TicTacToeViewModel : ViewModel() {

    // CONSTANTS FOR views text (DO NOT FIX)
    private val PLAYER_O = "O"
    private val PLAYER_X = "X"

    private val STATUS_PLAYING = "PLAYING..."
    private val STATUS_O_WIN = "PLAYER O WIN!"
    private val STATUS_X_WIN = "PLAYER X WIN!"
    private val STATUS_DRAW = "DRAW!"

    // recommended LiveData fields (fill free to fix it)
    val cells = ArrayList<MutableLiveData<String>>()
    val gameStatus = MutableLiveData<String>()
    private var whoseTurn = true

    init {
        for (i in 0..8) {
            cells.add(MutableLiveData())
        }
        restart()
    }

    // recommended function structures (fill free to fix it)
    fun clickCell(pos: Int) {
        if (!gameStatus.value.equals(STATUS_PLAYING)) return

        val cell = cells[pos]

        if (cell.value?.length == 0) {
            if (whoseTurn) cell.value = PLAYER_O
            else cell.value = PLAYER_X

            checkWinOrNot()
        }
    }

    fun restart() {
        for (i in 0..8) {
            cells[i].value = ""
        }
        gameStatus.value = STATUS_PLAYING
        whoseTurn = true
    }

    fun checkWinOrNot() {
        var isWin = false
        var turn = PLAYER_O
        if (!whoseTurn) turn = PLAYER_X

        // Draw 검사
        var cnt = 0
        for (i in 0..8) {
            if (cells[i].value?.length != 0) cnt++
        }
        if (cnt==9) {
            gameStatus.value = STATUS_DRAW
            return
        }

        // 가로 검사
        loop@ for (i in 0..2) {
            var cnt = 0

            for (j in i*3..i*3+2) {
                if (cells[j].value.equals(turn)) cnt++
            }

            if (cnt == 3) {
                isWin = true
                break@loop
            }
        }

        // 세로 검사
        loop@ for (i in 0..2) {
            var cnt = 0

            for (j in i..i+6 step 3) {
                if (cells[j].value.equals(turn)) cnt++
            }

            if (cnt == 3) {
                isWin = true
                break@loop
            }
        }

        // 대각선 검사
        cnt = 0
        for (i in 0..8 step 4) {
            // 2 4 6
            if (cells[i].value.equals(turn)) cnt++
        }
        if (cnt == 3) isWin = true

        cnt = 0
        for (i in 2..6 step 2) {
            if (cells[i].value.equals(turn)) cnt++
        }
        if (cnt == 3) isWin = true

        // 검사 결과 반영
        if (isWin) {
            if (whoseTurn) gameStatus.value = STATUS_O_WIN
            else gameStatus.value = STATUS_X_WIN
        } else {
            whoseTurn = !whoseTurn
        }
    }
}