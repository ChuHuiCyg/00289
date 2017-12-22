package com.run.treadmill.runningParamManager;

import android.content.Context;


public class RunParamTableManager {
	public static final String TAG = "RunParamTableManager";

	private static RunParamTableManager ourInstance = null;
		
	public static RunParamTableManager getInstance(Context context) {    
        if ( null == ourInstance ) {
            synchronized (RunParamTableManager.class) {
                if (null == ourInstance ) {
                    ourInstance = new RunParamTableManager(context);                    
                }
            }
        }
        return ourInstance;
    }
			
	private RunParamTableManager(Context context) {
		
	}

	public int proLevelTable[][] = { 
			{	4,5,6,7,8,  9,8,9,8,9,  8,9,8,9,8, 
				9,8,9,8,9,  8,9,8,9,8,  9,7,7,5,4 },

			{	4,5,6,10,6,  10,6,10,6,10,  6,10,6,10,6, 
				10,6,10,6,10,  6,10,6,10,6,  10,8,6,5,4 },

			{	1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1, 
				1,1,1,1,1,  1,1,1,1,1, 1,1,1,1,1 },

			{	1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1, 
				1,1,1,1,1,  1,1,1,1,1, 1,1,1,1,1 },

			{	1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1, 
				1,1,1,1,1,  1,1,1,1,1, 1,1,1,1,1 },

			{	1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1, 
				1,1,1,1,1,  1,1,1,1,1, 1,1,1,1,1 },

			{	2,4,4,6,6,  8,8,10,10,12,  12,14,14,16,16, 
				18,18,20,20,22,  22,1,1,1,1, 1,1,1,1,1 },

			{	1,1,1,1,1,  1,1,1,1,1,  1,1,1,1,1, 
				1,1,1,1,1,  1,1,1,1,1, 1,1,1,1,1 },

	};

	public float fintessVO2Max[] = { 31.15f,32.55f,33.6f,34.65f,35.35f,  37.45f,39.55f,41.3f,43.4f,44.1f,  
				45.15f,46.2f,46.5f,48.6f,50f,  51.4f,52.8f,53.9f,54.9f,56f,  57f,57.7f,58.8f,60.2f,61.2f,
				62.3f,63.3f,64f,65f,66.5f,  68.2f,69f,70.7f,72.1f,73.1f,  73.8f,74.9f,76.3f,77.7f,79.1f,
				80f };

	public int[][] vrSpeedValue = {
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
					1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
				
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
				
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
				
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},

					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
				
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
						1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,},
		};

	//横坐标为RPM20-120，纵坐标为Level1-36---2
	public int[][] wattTable = {
			 
		 {1,4,8,11,15,20,23,27,32,39,45},
		 {1,6,9,16,25,30,32,50,64,73,82},
		 {1,7,14,25,34,37,49,61,82,119,154},
		 {8,15,22,29,44,50,64,75,101,141,172},
		 {10,16,26,37,53,60,78,90,125,168,194},
		 {14,22,30,40,63,71,92,108,145,192,232},
		 {15,26,36,49,72,80,108,137,167,210,258},
		 {16,34,41,70,82,89,120,152,182,232,277},
		 {21,37,55,83,92,116,133,161,201,254,302},
		 {24,43,65,89,101,131,158,185,225,271,339},
		 {26,46,74,95,111,146,170,207,241,301,361},
		 {28,50,80,99,120,160,185,227,262,319,382},
		 {31,56,88,111,130,172,200,245,289,342,415},
		 {33,63,93,120,140,189,217,263,312,374,439},
		 {37,66,101,125,149,205,231,274,321,392,462},
		 {38,68,106,131,159,211,248,285,338,417,483},
		 {39,70,113,135,168,216,255,298,348,423,501},
		 {41,74,117,143,178,221,261,312,369,441,518},
		 {42,76,126,154,187,235,272,325,392,462,534},
		 {44,86,138,165,197,242,282,351,411,482,551},
		 {47,88,146,178,207,259,304,376,429,501,568},
		 {50,92,153,184,216,278,327,391,441,523,583},
		 {53,98,157,199,226,302,348,415,469,542,601},
		 {56,99,163,206,235,315,366,439,489,562,618},
		 {56,103,167,208,245,327,378,450,511,587,635},
		 {58,107,174,223,255,337,400,464,525,594,667},
		 {61,113,185,234,264,352,417,482,546,612,682},
		 {64,116,192,241,274,376,439,511,562,634,705},
		 {65,120,203,248,283,390,453,528,584,654,725},
		 {66,122,206,258,293,404,468,540,604,670,741},
		 {67,123,208,263,302,416,482,554,618,687,759},
		 {68,127,209,270,312,426,498,571,629,706,772},
		 {69,129,211,278,322,436,512,580,641,724,783},
		 {70,132,218,282,331,445,519,588,652,739,798},
		 {72,134,223,287,341,451,528,598,663,743,816},
		 {72,136,228,293,350,461,535,605,677,756,832},
		
	};
	
	/*{1,6,10,15,17,21,27,29,32,40,42},
	{3,8,15,20,25,32,38,60,62,67,76},
	{4,5,7,9,11,12,16,19,23,26,27},
	{5,6,9,11,14,16,20,25,29,33,34},
	{6,8,11,14,17,20,25,30,35,40,42},
	{8,10,14,18,22,26,31,37,42,47,51},
	{9,11,16,20,25,29,35,42,48,54,57},
	{10,13,19,25,31,36,42,50,56,61,66},
	{11,14,20,27,33,39,46,54,61,68,73},
	{12,16,23,30,36,43,51,59,67,75,80},
	{13,17,24,32,39,46,55,64,73,82,88},
	{14,18,26,34,42,50,60,70,80,89,95},
	{15,20,29,37,46,54,65,75,86,96,103},
	{16,22,31,40,49,58,69,81,92,103,111},
	{17,23,33,43,53,62,74,86,98,110,118},
	{19,25,36,46,57,67,80,92,105,117,125},
	{20,26,38,49,60,71,84,100,112,124,133},
	{21,28,40,52,64,75,90,105,118,131,141},
	{22,29,42,54,67,79,94,109,124,138,148},
	{23,31,44,58,71,84,99,115,130,145,156},
	{25,33,47,61,75,88,104,120,136,152,164},
	{26,34,49,63,78,92,109,125,145,159,171},
	{27,36,51,66,81,96,114,131,149,166,179},
	{28,37,53,69,85,101,119,137,155,173,186},
	{29,39,56,72,89,105,124,143,162,180,194},
	{31,41,58,75,92,109,129,150,168,187,202},
	{32,42,60,78,96,113,133,154,174,194,209},
	{33,44,62,81,99,117,138,159,180,201,217},
	{34,45,64,83,102,121,143,165,187,208,224},
	{35,46,66,86,106,125,148,170,193,215,232},
	{37,49,70,91,112,133,155,175,199,222,241},
	{38,51,73,94,116,137,159,180,205,229,250},
	{39,52,74,96,118,140,163,185,211,236,257},
	{41,54,77,99,122,144,169,190,219,243,265},
	{42,56,80,104,128,151,176,200,226,250,274},
	{43,57,82,106,131,155,181,205,232,257,281},*/
}