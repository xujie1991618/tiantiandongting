/**
 * MainActivity.java [V 1.0.0]
 * classes :　com.caryfish.tiantian.MainActivity
 * 徐杰  create at 2014-7-11 上午10:29:28
 */
package com.caryfish.tiantian;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

/**
 * com.caryfish.tiantian.MainActivity
 * @author 徐杰   <br/>
 * create at 2014-7-11 上午10:29:28
 */
public class MainActivity extends FragmentActivity{

	private LinearLayout title_ll;//首页Title
	private LinearLayout title_search_img;//首页查询按钮
	/**
	 * 我的界面的Fragment
	 */
	private MyFragment myFragment;

	/**
	 * 推荐界面的Fragment
	 */
	private RecommendFragment recommendFragment;

	/**
	 * 排行界面的Fragment
	 */
	private RankFragment rankFragment;
	/**
	 * 分类界面的Fragment
	 */
	private ClassFragment classFragment;
	/**
	 * PagerSlidingTabStrip的实例
	 */
	private PagerSlidingTabStrip tabs;
	/**
	 * 获取当前屏幕的密度
	 */
	private DisplayMetrics dm;
	/**
	 * 选项内容页
	 */
	ViewPager pager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.activity_main);
		
		InitView();//初始化
		
		InitData();//事件
	}

	/**
	 * 
	 */
	private void InitView() {
		// TODO Auto-generated method stub
		dm = getResources().getDisplayMetrics();
		pager = (ViewPager) findViewById(R.id.pager);
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		
		title_ll = (LinearLayout)findViewById(R.id.title_ll);
		title_search_img = (LinearLayout)findViewById(R.id.title_search_img);
	}

	/**
	 * 
	 */
	private void InitData() {
		// TODO Auto-generated method stub
		title_ll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "选中了头像", Toast.LENGTH_SHORT).show();
			}
		});
		title_search_img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "选中了查询", Toast.LENGTH_SHORT).show();
			}
		});
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		tabs.setViewPager(pager);
		setTabsValue();
	}
	/**
	 * 对PagerSlidingTabStrip的各项属性进行赋值。
	 */
	private void setTabsValue() {
		// 设置Tab是自动填充满屏幕的
		tabs.setShouldExpand(true);
		// 设置Tab的分割线是透明的
		tabs.setDividerColor(Color.TRANSPARENT);
		// 设置Tab底部线的高度
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// 设置Tab Indicator的高度
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// 设置Tab标题文字的大小
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// 设置Tab Indicator的颜色
		tabs.setIndicatorColor(Color.parseColor("#45c01a"));
		// 设置选中Tab文字的颜色 (这是我自定义的一个方法)
		tabs.setSelectedTextColor(Color.parseColor("#45c01a"));
		// 取消点击Tab时的背景色
		tabs.setTabBackground(0);
	}
	public class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		private final String[] titles = { "我的", "推荐", "排行", "分类" };

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				if ( myFragment== null) {
					myFragment = new MyFragment();
				}
				return myFragment;
			case 1:
				if (recommendFragment == null) {
					recommendFragment = new RecommendFragment();
				}
				return recommendFragment;
			case 2:
				if (rankFragment == null) {
					rankFragment = new RankFragment();
				}
				return rankFragment;
			case 3:
				if (classFragment == null) {
					classFragment = new ClassFragment();
				}
				return classFragment;
			default:
				return null;
			}
		}

	}
}
