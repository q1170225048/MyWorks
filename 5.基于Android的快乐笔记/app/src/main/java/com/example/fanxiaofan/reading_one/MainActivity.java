package com.example.fanxiaofan.reading_one;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //变量***********************************************************************
    private SectionsPagerAdapter mSectionsPagerAdapter;
     //Tviewpage 部分的内容
    private ViewPager mViewPager;
    private TextView head;
    private static String Username;
    private static String headStr="";
    private static Context mcontext;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mcontext=getApplicationContext();

        setContentView(R.layout.main_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // primary sections of the activity.
        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter =new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.containerT);
        mViewPager.setAdapter(mSectionsPagerAdapter);


//        if(!headStr.equals(""))
//        {
//            headname.setText(headStr);
//        }
//        else
//        {
//            headname.setText(Username);
//        }

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //head=(TextView)findViewById(R.id.headname);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            About.actionStart(MainActivity.this);
        }else if(id==R.id.action_exit)
        {
            finish();
        }

        return true;
        //return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            //MainActivity.PlaceholderFragment fragment=PlaceholderFragment.newInstance(2);
            //mSectionsPagerAdapter =new SectionsPagerAdapter(getSupportFragmentManager());
            //mViewPager.setAdapter(mSectionsPagerAdapter);
            mViewPager.setCurrentItem(2, true);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            mViewPager.setCurrentItem(0, true);

        } else if (id == R.id.nav_slideshow) {
            mViewPager.setCurrentItem(1, true);

        }  else if (id == R.id.nav_share) {
            //汇总
            Summary.actionStart(MainActivity.this,Username);

        } else if (id == R.id.nav_send) {
            //统计
            CountNote.actionStart(MainActivity.this,Username);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // 函数自定义 ******************************************************************
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void actionStart(Context context,String username) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        Username=username;
    }
    public static void actionStart(Context context,String username,String headname) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        Username=username;
        headStr=headname;
    }

    /**
     * 一个占位符片段包含一个简单的视图。
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static MainActivity.PlaceholderFragment newInstance(int sectionNumber) {
            MainActivity.PlaceholderFragment fragment = new MainActivity.PlaceholderFragment();

            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.d("ReadingNote","创建视图");

            int item=getArguments().getInt(ARG_SECTION_NUMBER);
            View rootView = inflater.inflate(R.layout.fragment_test, container, false);

            Button button=(Button)rootView.findViewById(R.id.button);
            Button button2=(Button)rootView.findViewById(R.id.button2);
            Button button3=(Button)rootView.findViewById(R.id.button3);
            Button button4=(Button)rootView.findViewById(R.id.button4);

            if(item==1)
            {
                button.setText("添加书籍");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击添加图书");
                        AddBook.actionStart(view.getContext(),Username);
                        Log.d("ReadingNote","不执行");
                    }
                });
                button2.setText("查看书籍");
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击查看图书");
                        LookBook.actionStart(view.getContext(),Username);
                        Log.d("ReadingNote","不执行");
                    }
                });
                button3.setText("修改书籍");
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击修改图书");
                        EditBook.actionStart(view.getContext(),Username);
                        Log.d("ReadingNote","不执行");
                    }
                });
                button4.setText("删除书籍");
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击删除图书");
                        DeleteBook.actionStart(view.getContext(),Username);
                        Log.d("ReadingNote","不执行");
                    }
                });
            }
            else if(item==2)
            {
                button.setText("添加笔记");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击添加笔记");
                        AddNote.actionStart(view.getContext(),Username);
                        Log.d("ReadingNote","不执行");
                    }
                });
                button2.setText("查看笔记");
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击查看图书");
                        LookNote.actionStart(view.getContext(),Username);
                        Log.d("ReadingNote","不执行");
                    }
                });
                button3.setText("修改笔记");
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击修改图书");
                        EditNote.actionStart(view.getContext(),Username);
                        Log.d("ReadingNote","不执行");
                    }
                });
                button4.setText("删除笔记");
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击删除图书");
                        DeleteNote.actionStart(view.getContext(),Username);
                        Log.d("ReadingNote","不执行");
                    }
                });
            }
            else
            {
                button.setText("添加分类");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击添加分类");
                        AddClassStr.actionStart(view.getContext(),Username);
                    }
                });
                button2.setText("查看分类");
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击查看分类");
                        LookClassStr.actionStart(view.getContext(),Username);
                    }
                });
                button3.setText("修改分类");
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击修改分类");
                        EditClassStr.actionStart(view.getContext(),Username);
                    }
                });
                button4.setText("删除分类");
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("ReadingNote","点击删除分类");
                        DeleteClassStr.actionStart(view.getContext(),Username);
                    }
                });
            }
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            return rootView;
        }
    }
    //另一个类（没搞懂）
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return MainActivity.PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
