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



}
