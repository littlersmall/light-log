# light-log

1 基于aop实现的log系统

2 使用示例:
```
@Log()
public void fun(int param);
```

3 打印结果示例:
```
[2017-07-03 20:47:21.683][INFO][TestInterface][67][logId:] - class:com.littlersmall.example.TestInterface, function:fun
in args: [3], out args: null
execute time: 14
```
