name := "volga"

version := "0.1"

scalaVersion in ThisBuild := "0.14.0-RC1"

val catsVersion =  "1.6.0"

lazy val core = (project in file("modules/core"))
  .settings(
      libraryDependencies += ("org.typelevel" %% "cats-core" % catsVersion).withDottyCompat(scalaVersion.value),
      libraryDependencies += ("org.typelevel" %% "cats-free" % catsVersion).withDottyCompat(scalaVersion.value)

  )
lazy val macros = project in file("modules/macros")

scalacOptions ++=
  List(
    "-Ypartial-unification",
    "-language:higherKinds"
  )