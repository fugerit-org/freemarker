# freemarker-test-native

Test project for GraalVM support

Requirements : 

- GraalVM 21+

## Quickstart

1. Build and publish to local maven repository freemarker.kar

2. Check that the 'freemarkerVersion' variable in 'build.gradle.kts' is correctly set (as the main project version at step 1)

3. Build the project : 

```shell
./gradle clean nativeCompile
```

4. Run the project :

```shell
./build/native/nativeCompile/freemarker-test-native
```

Output should be similar to : 

```txt
INFO: name : FreeMarker Native Demo, version : 2.3.35-nightly
Jan 15, 2025 4:28:19 PM freemarker.log._JULLoggerFactory$JULLogger info
INFO: result :
<html>
    <head>
        <title>Hello : FreeMarker Native Demo</title>
    </head>
    <body>
        <h1>Hello : FreeMarker Native Demo</h1>
        <p>Test template for Apache FreeMarker native support (2.3.35-nightly)</p>
    </body>
</html>
```

## CI native pipeline (GitHub)

The full process is automated with the [CI native](../.github/workflows/ci-native.yml) pipeline.