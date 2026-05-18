# 스트림 API

- 컬렉션에 추가된 메서드의 집합.
- 컬렉션에 담긴 데이터를 처리한다.

## forEach()

- 컬렉션의 요소들을 하나씩 꺼내서 반복한다.

### 사용 예시

```java

list.stream().forEach(value->System.out.println(value));

```

## filter()

- 컬렉션의 요소들 중 조건문에 맞는 요소만 뽑아 새로운 스트림을 만든다.

### 사용 예시

```java

List evenList=list.stream().filter(value -> value%2==0).toList();

```

## distinct()

- 컬렉션의 요소에서 중복을 제거한다.
- 중복 여부는 equals()에서 판단한다.

### 사용 예시

```java

List<Integer> distinctList=list.stream().distinct().toList();

```

## map()

- 컬렉션의 요소들에 특정 연산을 적용한 새로운 스트림을 만든다.

### 사용 예시

```java

List<String> uppercaseList=lowerCaseList.stream().map(value -> value.toUpperCase()).toList();

```
