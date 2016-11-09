package com.murphy.china.testaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AidlService extends Service {

    private List<Book> mBooks  = new ArrayList<Book>();

    public AidlService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book();
        book.setName("计算机科学与技术");
        mBooks.add(book);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }

    private ServiceAidl mBinder = new ServiceAidl.Stub() {
        @Override
        public void add(Book book) throws RemoteException {
            if(mBooks!=null) {
                mBooks.add(book);
                Log.d("TAG","size---------->"+mBooks.size());
            }
        }

        @Override
        public int addNum(int num1, int num2) throws RemoteException {
            return num1 + num2;
        }

        @Override
        public List<Book> get() throws RemoteException {
            return mBooks;
        }


    };


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return (IBinder) mBinder;
    }
}
