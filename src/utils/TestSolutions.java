package utils;

import kyu5.PaginationHelper;

import java.util.List;

public class TestSolutions {

    public static void main(String[] args) {
        testPaginatorHelper();
    }

    private static void testPaginatorHelper() {
        List<Character> collection = List.of('a', 'b', 'c', 'd', 'e', 'f');
        PaginationHelper paginationHelper = new PaginationHelper(collection, 4);

        System.out.println( paginationHelper.pageCount() );
    }


}
