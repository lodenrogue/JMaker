# JMaker
Java Library for IFTTT Maker Channel

## How to use
```Java

// With values
List<String> values = new ArrayList<String>();
values.add("Test");
values.add("Second test");
values.add("Third test");

JMaker maker = new JMaker("event_name", "key123123523aww31313");
maker.trigger(values);

// OR without values
new JMaker("event_name", "key123123523aww31313").trigger();


```
