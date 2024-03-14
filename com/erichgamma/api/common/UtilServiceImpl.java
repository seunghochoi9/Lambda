package com.erichgamma.api.common;

public class UtilServiceImpl implements UtilService {
    private static final UtilService instance = new UtilServiceImpl();

    private UtilServiceImpl() {
    }

    public static UtilService getInstance() {
        return instance;
    }

    public int createRandomInteger(int start, int gap) {
        return start + (int) (Math.random() * gap);
    }

    public double createRandomDouble(int start, int gap) {
        return Math.round((start + Math.random() * gap) * 10) / 10.0;
    }

    public String createRandomUsername(){
        String username = "";
        for(;
            username.length() < 5;
            username += String.valueOf((char)('a' + this.createRandomInteger(0, 26)))
        );
        return username;
//        내 코딩
//        String[] usernamePool = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
//        String username = "";
//        for(int i=0;i<5;i++){
//            String a = usernamePool[createRandomInteger(0, 26)];
//            username = username + a;
//        }
    }


    public String createRandomName() {
        String[] names = {"이정재", "마동석", "송강호", "윤여정", "황정민",
                "정우성", "이병헌", "현 빈", "유해진", "손석구", "전도연",
                "손예진", "하지원", "김하늘", "송중기", "하정우", "장동건",
                "원 빈", "박해일", "소지섭", "김혜수"};
        return names[createRandomInteger(0, 20)];
    }

    @Override
    public String createRandomTitle() {
        String[] title = {"각급 선거관리위원회", "대통령의 임기는", "형사피의자",
        "대통령은 국민의", "이 헌법공포 당시의", "제2항과 제3항의 처분", "헌법개정안은 국회",
        "대통령은 취임", "제2항의 재판관중", "근로자는 근로조건", "국회는 국가의",
        "의무교육은 무상으로 한다", "대통령이 제1항의 기간"};
        return title[createRandomInteger(0, 13)];
    }

    @Override
    public String createRandomContent() {
        String[] content = {"각급 선거관리위원회는 선거인명부의 작성등 선거사무와 국민투표사무에 관하여 관계 행정기관에 필요한 지시를 할 수 있다.",
                "대통령의 임기는 5년으로 하며, 중임할 수 없다. 모든 국민은 학문과 예술의 자유를 가진다.",
                "형사피의자 또는 형사피고인으로서 구금되었던 자가 법률이 정하는 불기소처분을 받거나 무죄판결을 받은 때에는 법률이 정하는 바",
                "대통령은 국민의 보통·평등·직접·비밀선거에 의하여 선출한다.",
                "이 헌법공포 당시의 국회의원의 임기는 제1항에 의한 국회의 최초의 집회일 전일까지로 한다.",
                "제2항과 제3항의 처분에 대하여는 법원에 제소할 수 없다. 타인의 범죄행위로 인하여 생명·신체에 대한 피해를 받은 국민은 법률이 정",
                "헌법개정안은 국회가 의결한 후 30일 이내에 국민투표에 붙여 국회의원선거권자 과반수의 투표와 투표자 과반수의 찬성을 얻어야 한다.",
                "대통령은 취임에 즈음하여 다음의 선서를 한다. 대통령은 내란 또는 외환의 죄를 범한 경우를 제외하고는 재직중 형사상의 소추를 받지 아니한다.",
                "제2항의 재판관중 3인은 국회에서 선출하는 자를, 3인은 대법원장이 지명하는 자를 임명한다.",
                "근로자는 근로조건의 향상을 위하여 자주적인 단결권·단체교섭권 및 단체행동권을 가진다.",
                "국회는 국가의 예산안을 심의·확정한다. 국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다.",
                "의무교육은 무상으로 한다. 각급 선거관리위원회의 조직·직무범위 기타 필요한 사항은 법률로 정한다.",
                "대통령이 제1항의 기간내에 공포나 재의의 요구를 하지 아니한 때에도 그 법률안은 법률로서 확정된다."};
        return content[createRandomInteger(0, 13)];
    }
    @Override
    public String createRandomCompany(){
        String[] companies = {"구글", "엔비디아", "메타", "삼성", "LG", "애플"};
        return null;
    }
    @Override
    public String createRandomJob() {
        String[] names = {"경찰", "소방관", "세일즈맨", "교수", "회계사",
                "공무원", "의사"};
        return names[createRandomInteger(0,6)];
    }

}
