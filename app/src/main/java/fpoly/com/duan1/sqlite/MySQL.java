package fpoly.com.duan1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import fpoly.com.duan1.model.CauHoi1;
import fpoly.com.duan1.model.CauHoi2;
import fpoly.com.duan1.model.CauHoi3;
import fpoly.com.duan1.model.DiemCao;
import fpoly.com.duan1.model.TaiKhoan;
import fpoly.com.duan1.model.XepHang;

public class MySQL extends SQLiteOpenHelper {


    //destination path (location) of our database on device
    private static String DB_PATH = "";
    private static String DB_NAME = "duan1.db";// Database name
    private SQLiteDatabase mDataBase;
    private final Context mContext;


    // do đường dẫn ở phiên bản API > 17 thay đổi nên chúng ta cần kiểm tra nhé
    public MySQL(Context context) {
        super(context, DB_NAME, null, 1);// 1? Its database Version
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }


 //Các câu lênh truy vấn

    //Lấy tất cả câu hỏi ở mức 1
    public List<CauHoi1> getAllCauHoi1() {
        List<CauHoi1> books = new ArrayList<>();
        String SELECT = "SELECT * FROM Questions WHERE level =1";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                books.add(new CauHoi1(cursor.getString(1),cursor.getString(0),cursor.getString(6),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return books;
    }


    //Lấy tất cả câu hỏi ở mức 2
    public List<CauHoi2> getAllCauHoi2() {
        List<CauHoi2> books = new ArrayList<>();
        String SELECT = "SELECT * FROM Questions WHERE level =2";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                books.add(new CauHoi2(cursor.getString(1),cursor.getString(0),cursor.getString(6),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return books;
    }


    //Lấy tất cả câu hỏi ở mức 3
    public List<CauHoi3> getAllCauHoi3() {
        List<CauHoi3> books = new ArrayList<>();
        String SELECT = "SELECT * FROM Questions WHERE level =3";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                books.add(new CauHoi3(cursor.getString(1),cursor.getString(0),cursor.getString(6),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return books;
    }

    //Tài khoản
    public void insertUser(TaiKhoan taiKhoan){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",taiKhoan.getUsername());
        contentValues.put("Password",taiKhoan.getPassword());
        contentValues.put("Player",taiKhoan.getPlayer());
        sqLiteDatabase.insert("Manager",null,contentValues);
        sqLiteDatabase.close();
    }

    public String getTaiKhoan(String username) {
        String taiKhoan = null;
        String SELECT = "SELECT * FROM  Manager WHERE username like '"+username+"'";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                taiKhoan=cursor.getString(0);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return taiKhoan;
    }

    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> taiKhoan=new ArrayList<>();
        String SELECT = "SELECT * FROM  Manager";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                taiKhoan.add(new TaiKhoan(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return taiKhoan;
    }

    //điẻmm cao
    public void insertDiem(DiemCao diemCao){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Score",diemCao.getSoDiem());
        contentValues.put("idUser",diemCao.getIdUser());
        sqLiteDatabase.insert("HighScore",null,contentValues);
        sqLiteDatabase.close();
    }


    public List<XepHang> getAllDiemCao() {
        List<XepHang> taiKhoan=new ArrayList<>();
        String SELECT = "SELECT * FROM HighScore a INNER JOIN Manager b on a.idUser=b.id ORDER by Score DESC LIMIT 10";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                taiKhoan.add(new XepHang(cursor.getString(1),cursor.getString(6) ));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return taiKhoan;
    }



    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
