# CRPG304-B_Gr7-Assignment1

## Building (this should be first!)

```bash
gradle build
```

## Running

1. Running with Gradle

```ps1
gradle execJar "--args= -f<file_name> -t<compare_type> -s<shape_type>"
```

2. Running with `java`

```ps1
java -jar 'build/libs/Sort.jar' -f<file_name> -t<compare_type> -s<shape_type>
```
