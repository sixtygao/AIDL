// ServiceAidl.aidl
package com.murphy.china.testaidl;
// Declare any non-default types here with import statements
import com.murphy.china.testaidl.Book ;

interface ServiceAidl {

   void add(in Book book) ;

   int addNum(int num1 ,int num2);

   List<Book> get() ;

}
