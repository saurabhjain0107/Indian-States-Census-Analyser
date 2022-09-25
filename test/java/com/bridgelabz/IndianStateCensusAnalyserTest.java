package com.bridgelabz;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class IndianStateCensusAnalyserTest {
    static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String CENSUS_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//IndiaStateCensusData.csv") ;
    private static final String CENSUS_INCORRECT_FILE_PATH = PROJECT_PATH.concat("//C//src//main//resources//India_StateCensusData.csv");
    private static final String CENSUS_INCORRECT_TYPE_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//IndiaStateCensusData.pde");
    private static final String CENSUS_INCORRECT_DELIMITER_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//Indian_States_Census_Incorrect_Delimiter.csv");
    private static final String CENSUS_INCORRECT_HEADER_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//Indian_States_Census_Incorrect_header.csv");
    private static final String CSV_STATES_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//IndiaStateCode.csv");
    private static final String CSV_STATES_INCORRECT_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//India_StateCode.csv");
    private static final String CSV_STATES_INCORRECT_TYPE_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//IndiaStateCode.pdf");
    private static final String CSV_STATES_INCORRECT_DELIMITER_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//India_StateCode_Incorrect_Delimiter.csv") ;
    private static final String CSV_STATES_INCORRECT_HEADER_FILE_PATH = PROJECT_PATH.concat("//src//main//resources//India_StateCode_Incorrect_header.csv");

    @Test
    void givenCSVFile_ShouldMatch_NumberOfRecords() throws IOException, CensusAnalyserException, CsvException {
        StateCensusAnalyser.csvStateCensuses.clear();
       int countOfRecords = StateCensusAnalyser.loadData(new File(CENSUS_FILE_PATH));
        Assertions.assertEquals(29, countOfRecords);
    }
    @Test
    void givenCSVFileIncorrectPath_ShouldThrowException(){
        File file = new File(CENSUS_INCORRECT_FILE_PATH);
        Assertions.assertThrows(CensusAnalyserException.class,() -> StateCensusAnalyser.loadData(file));
    }
    @Test
    void givenCSVFileIncorrectType_ShouldThrowException() {
        File file = new File(CENSUS_INCORRECT_TYPE_FILE_PATH);
        Assertions.assertThrows(CensusAnalyserException.class, () -> StateCensusAnalyser.loadData(file));
    }
    @Test
    void givenCSVFileIncorrectDelimiter_ShouldThrowException() {
        File file = new File(CENSUS_INCORRECT_DELIMITER_FILE_PATH);
        Assertions.assertThrows(CensusAnalyserException.class, () -> StateCensusAnalyser.loadData(file));
    }
    @Test
    void givenCSVFileIncorrectHeader_ShouldThrowException() {
        File file = new File(CENSUS_INCORRECT_HEADER_FILE_PATH);
        Assertions.assertThrows(CensusAnalyserException.class, () -> StateCensusAnalyser.loadData(file));
    }

    //************************************************
//Ability for the analyser to load the Indian States Code Information from a csv file

    @Test
    void givenCSVStateFile_ShouldMatch_NumberOfRecords() throws IOException, CsvException, CensusAnalyserException {
        StateCensusAnalyser.csvStateCensuses.clear();
        int countOfRecords = StateCensusAnalyser.loadStates(new File(CSV_STATES_FILE_PATH));
        Assertions.assertEquals(37, countOfRecords);
    }

    @Test
    void givenCSVStateFileIncorrectPath_ShouldThrowException() {
        File file = new File(CSV_STATES_INCORRECT_FILE_PATH);
        Assertions.assertThrows(CensusAnalyserException.class, () -> StateCensusAnalyser.loadStates(file));
    }

    @Test
    void givenCSVStateFileIncorrectType_ShouldThrowException() {
        File file = new File(CSV_STATES_INCORRECT_TYPE_FILE_PATH);
        Assertions.assertThrows(CensusAnalyserException.class, () -> StateCensusAnalyser.loadStates(file));
    }

    @Test
    void givenCSVStateFileIncorrectDelimiter_ShouldThrowException() {
        File file = new File(CSV_STATES_INCORRECT_DELIMITER_FILE_PATH);
        Assertions.assertThrows(CensusAnalyserException.class, () -> StateCensusAnalyser.loadStates(file));
    }

    @Test
    void givenCSVStateFileIncorrectHeader_ShouldThrowException() {
        File file = new File(CSV_STATES_INCORRECT_HEADER_FILE_PATH);
        Assertions.assertThrows(CensusAnalyserException.class, () -> StateCensusAnalyser.loadStates(file));
    }

}
