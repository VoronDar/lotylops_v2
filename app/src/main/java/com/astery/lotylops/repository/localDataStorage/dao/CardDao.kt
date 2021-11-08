package com.astery.lotylops.repository.localDataStorage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.astery.lotylops.model.entities.*

@Dao
interface CardDao {
    @Query("SELECT * FROM VOCABULARYCARD WHERE repetitionDate <= :today ORDER BY practiceLevel")
    suspend fun getVocabularyCardsForToday(today:Int):List<VocabularyCard>

    @Query("SELECT * FROM VOCABULARYCARD WHERE course == :courseId ORDER BY id")
    suspend fun getVocabularyCardsForCourse(courseId:String):List<VocabularyCard>

    @Query("SELECT * FROM VOCABULARYCARD WHERE id == :id")
    suspend fun getVocabularyCard(id:String): VocabularyCard

    @Query("DELETE FROM VOCABULARYCARD WHERE id = :id")
    fun deleteVocabularyCard(id: String)

    @Query("DELETE FROM VOCABULARYCARD")
    fun deleteVocabularyCards()

    @Insert(onConflict = REPLACE)
    suspend fun addCard(card: VocabularyCard)

    @Update(onConflict = REPLACE)
    suspend fun updateCard(card: VocabularyCard)

    @Query("SELECT * FROM PHRASEOLOGYCARD WHERE repetitionDate <= :today ORDER BY practiceLevel")
    suspend fun getPhraseologyCardsForToday(today:Int):List<PhraseologyCard>

    @Query("SELECT * FROM PHRASEOLOGYCARD WHERE course == :courseId ORDER BY id")
    suspend fun getPhraseologyCardsForCourse(courseId:String):List<PhraseologyCard>

    @Query("SELECT * FROM PHRASEOLOGYCARD WHERE id == :id")
    suspend fun getPhraseologyCard(id:String): PhraseologyCard

    @Insert(onConflict = REPLACE)
    suspend fun addCard(card: PhraseologyCard)

    @Update(onConflict = REPLACE)
    suspend fun updateCard(card: PhraseologyCard)

    @Query("DELETE FROM PHRASEOLOGYCARD WHERE id = :id")
    fun deletePhraseologyCard(id: String)

    @Query("DELETE FROM PHRASEOLOGYCARD")
    fun deletePhraseologyCards()

    @Query("SELECT * FROM GRAMMARCARD WHERE repetitionDate <= :today ORDER BY practiceLevel")
    suspend fun getGrammarCardsForToday(today:Int):List<GrammarCard>

    @Query("SELECT * FROM GRAMMARCARD WHERE course == :courseId ORDER BY id")
    suspend fun getGrammarCardsForCourse(courseId:String):List<GrammarCard>

    @Query("SELECT * FROM GRAMMARCARD WHERE id == :id")
    suspend fun getGrammarCard(id:String): GrammarCard

    @Insert(onConflict = REPLACE)
    suspend fun addCard(card: GrammarCard)

    @Update(onConflict = REPLACE)
    suspend fun updateCard(card: GrammarCard)


    @Query("DELETE FROM GRAMMARCARD WHERE id = :id")
    fun deleteGrammarCard(id: String)

    @Query("DELETE FROM GRAMMARCARD")
    fun deleteGrammarCards()

    @Query("SELECT * FROM EXCEPTIONCARD WHERE repetitionDate <= :today ORDER BY practiceLevel")
    suspend fun getExceptionCardsForToday(today:Int):List<ExceptionCard>

    @Query("SELECT * FROM EXCEPTIONCARD WHERE course == :courseId ORDER BY id")
    suspend fun getExceptionCardsForCourse(courseId:String):List<ExceptionCard>

    @Query("SELECT * FROM EXCEPTIONCARD WHERE id == :id")
    suspend fun getExceptionCard(id:String): ExceptionCard

    @Insert(onConflict = REPLACE)
    suspend fun addCard(card: ExceptionCard)

    @Update(onConflict = REPLACE)
    suspend fun updateCard(card: ExceptionCard)

    @Query("DELETE FROM EXCEPTIONCARD WHERE id = :id")
    fun deleteExceptionCard(id: String)

    @Query("DELETE FROM EXCEPTIONCARD")
    fun deleteExceptionCards()


    @Query("SELECT * FROM CULTURECARD WHERE repetitionDate <= :today ORDER BY practiceLevel")
    suspend fun getCultureCardsForToday(today:Int):List<CultureCard>

    @Query("SELECT * FROM CULTURECARD WHERE course == :courseId ORDER BY id")
    suspend fun getCultureCardsForCourse(courseId:String):List<CultureCard>

    @Query("SELECT * FROM CULTURECARD WHERE id == :id")
    suspend fun getCultureCard(id:String): CultureCard

    @Insert(onConflict = REPLACE)
    suspend fun addCard(card: CultureCard)

    @Update(onConflict = REPLACE)
    suspend fun updateCard(card: CultureCard)

    @Query("DELETE FROM CULTURECARD WHERE id = :id")
    fun deleteCultureCard(id: String)

    @Query("DELETE FROM CULTURECARD")
    fun deleteCultureCards()


    @Query("SELECT * FROM PHONETICSCARD WHERE repetitionDate <= :today ORDER BY practiceLevel")
    suspend fun getPhoneticsCardsForToday(today:Int):List<PhoneticsCard>

    @Query("SELECT * FROM PHONETICSCARD WHERE course == :courseId ORDER BY id")
    suspend fun getPhoneticsCardsForCourse(courseId:String):List<PhoneticsCard>

    @Query("SELECT * FROM PHONETICSCARD WHERE id == :id")
    suspend fun getPhoneticsCard(id:String): PhoneticsCard

    @Insert(onConflict = REPLACE)
    suspend fun addCard(card: PhoneticsCard)

    @Update(onConflict = REPLACE)
    suspend fun updateCard(card: PhoneticsCard)

    @Query("DELETE FROM PHONETICSCARD WHERE id = :id")
    fun deletePhoneticsCard(id: String)

    @Query("DELETE FROM PHONETICSCARD")
    fun deletePhoneticsCards()


}