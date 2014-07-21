/**
 * MainActivity.java [V 1.0.0]
 * classes :��com.caryfish.tiantian.MainActivity
 * ���  create at 2014-7-11 ����10:29:28
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
 * @author ���   <br/>
 * create at 2014-7-11 ����10:29:28
 */
public class MainActivity extends FragmentActivity{

	private LinearLayout title_ll;//��ҳTitle
	private LinearLayout title_search_img;//��ҳ��ѯ��ť
	/**
	 * �ҵĽ����Fragment
	 */
	private MyFragment myFragment;

	/**
	 * �Ƽ������Fragment
	 */
	private RecommendFragment recommendFragment;

	/**
	 * ���н����Fragment
	 */
	private RankFragment rankFragment;
	/**
	 * ��������Fragment
	 */
	private ClassFragment classFragment;
	/**
	 * PagerSlidingTabStrip��ʵ��
	 */
	private PagerSlidingTabStrip tabs;
	/**
	 * ��ȡ��ǰ��Ļ���ܶ�
	 */
	private DisplayMetrics dm;
	/**
	 * ѡ������ҳ
	 */
	ViewPager pager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		setContentView(R.layout.activity_main);
		
		InitView();//��ʼ��
		
		InitData();//�¼�
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
				Toast.makeText(MainActivity.this, "ѡ����ͷ��", Toast.LENGTH_SHORT).show();
			}
		});
		title_search_img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "ѡ���˲�ѯ", Toast.LENGTH_SHORT).show();
			}
		});
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		tabs.setViewPager(pager);
		setTabsValue();
	}
	/**
	 * ��PagerSlidingTabStrip�ĸ������Խ��и�ֵ��
	 */
	private void setTabsValue() {
		// ����Tab���Զ��������Ļ��
		tabs.setShouldExpand(true);
		// ����Tab�ķָ�����͸����
		tabs.setDividerColor(Color.TRANSPARENT);
		// ����Tab�ײ��ߵĸ߶�
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// ����Tab Indicator�ĸ߶�
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// ����Tab�������ֵĴ�С
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// ����Tab Indicator����ɫ
		tabs.setIndicatorColor(Color.parseColor("#45c01a"));
		// ����ѡ��Tab���ֵ���ɫ (�������Զ����һ������)
		tabs.setSelectedTextColor(Color.parseColor("#45c01a"));
		// ȡ�����Tabʱ�ı���ɫ
		tabs.setTabBackground(0);
	}
	public class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		private final String[] titles = { "�ҵ�", "�Ƽ�", "����", "����" };

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
