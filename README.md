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

```bash
java -jar 'build/libs/Sort.jar' -f<file_name> -t<compare_type> -s<shape_type>
```

3. Or using the **run** scripts

```bash
./run -f<file_name> -t<compare_type> -s<shape_type>
```

```bat
.\run.bat -f<file_name> -t<compare_type> -s<shape_type>
```
