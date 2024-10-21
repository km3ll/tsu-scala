# learn-basics

## commands

```base
sbt check
```

## proposal

- Circe
  - .asJson
  - .decode
  - .encode
  - .noSpaces
- Companion Objects
- Context
  - transaction
- Currying
- Custom Types
- Either
  - .asLeft
  - .asRight
  - .cond
  - .leftMap
  - .toEitherT
- EitherT
  - .cond
  - .fromEither
  - .fromOption
  - .left
  - .pure
  - .right
- Environment
- Event
- Execution Context
- Generics
  - C <: Context
  - D <: Dto
  - R <: Response
- For-Comprehension
- Functions
  - .flatMap
  - .fold
  - .forAll
  - .forEach
  - .map
  - .mapN
  - .toValidatedNel
- Future
  - .successful
- Generics
- HOF
- Implicit
  - ExecutionContext
  - Scheduler
- Integer
  - .abs
- Kleisli
  - .mapF (future)
  - .liftF
  - .run
- List
  - .empty
  - .filter
  - .filterNot
  - .headOption
  - .size
  - ::: (add)
  - ++
- Map
  - .empty
- Monix
- Option
  - .getOrElse
  - .nonEmpty
  - .some
  - .toRight
- Pattern Matching
- Queue
- Scheduler
- String
  - .contains
  - .hashCode
  - .length
  - .toLowerCase
  - .replace
  - .replaceAll
- StringLike
  - .format
- Task
  - .flatten
  - .now
  - .runToFuture
  - .unit
- Transformers
- Try
  - .toOption
- Validated
- ZonedDateTime
  - .format
  - .isAfter
  - .parse
  - .plusDays
  - .truncatedTo

## topics

- Asynchronous test
- Configurations
- Generators
- Logging
- Property test

## references

- [PureConfig](https://github.com/pureconfig/pureconfig)
- [ScalaCheck](https://github.com/typelevel/scalacheck/blob/main/doc/UserGuide.md)
- [ScalaTest](https://www.scalatest.org/user_guide/selecting_a_style)
