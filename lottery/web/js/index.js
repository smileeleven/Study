$(function () {
    var group = [{"group":"从零开始","nums":["方飞","高鹏","李恒","刘青","杨彦娇","赵泽宇"]},
                 {"group":"Hello Shanghai","nums":["王俊将","于锐信","沈明辉","胡蝶","宋子安"]},
                 {"group":"1024","nums":["胡一凡","温韶晖","陈伯利","任强","赵荣坤"]},
                 {"group":"火力全开","nums":["吴秦忠","陆育静","张沛","韩磊磊","虎鹏瑞","白展恺"]},
                 {"group":"May Day","nums":["史建亮","杨鹏宇","焦普春","路鹏","马院红"]},
                 {"group":"青春花少","nums":["申泽军","白昊天","褚乾江","王福强","付辰辰"]},
                 {"group":"飞梦","nums":["贾增强","秦慧超","韩永","李忠富","张辉耀","胡金华"]},
                 {"group":"卓尔不群","nums":["郭宇浩","左士杰","王肃国","林新福","杨健乐"]}];
    var choosed = [];
    var startFlag = false;
    var startHandler;
    var model = 1;
    showStartOrStop();


    $("#start").click(function () {
        start();
        startFlag = true;
        showStartOrStop();
    });

    $("#stop").click(function () {
        clearInterval(startHandler);
        startFlag = false;
        showStartOrStop();
        selectModel();
        var lucker = $("#num").val();
        if(model == 2){
            choosed.push(lucker);
        }
        $("#result").append("&nbsp;" + lucker);
    });

    // 开始抽奖
    function start() {
        var gruopsNum = randomNumBoth(0, group.length - 1);
        $("#groups").val(group[gruopsNum].group);
        var crew = group[gruopsNum].nums;
        var crewNum = randomNumBoth(0, crew.length - 1);
        if(model == 2){
            if(!isChoosed(crew[crewNum])){
                $("#num").val(crew[crewNum]);
            }
        }else{
            $("#num").val(crew[crewNum]);
        }
        startHandler = setTimeout(start, 0);
    }

    // 判断是否是在已选列表的
    function isChoosed(name) {
        for(var i=0;i<choosed.length;i++){
           if(choosed[i] == name){
               return true;
           }
        }
        return false;
    }

    // 查看选中的抽奖模式
    function selectModel() {
        model = $("input[name='model']:checked").val();
    }

    //生成指定范围随机数 Min <= num <= Max
    function randomNumBoth(Min,Max){
        var Range = Max - Min;
        var Rand = Math.random();
        return Min + Math.round(Rand * Range);
    }

    // 指定按钮的显示与隐藏
    function showStartOrStop() {
        if(!startFlag){
            $("#start").show();
            $("#stop").hide();
        }else{
            $("#start").hide();
            $("#stop").show();
        }

    }
});