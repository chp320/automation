import java.io.File

class Build {
	srcDir = "src"
	buildDir = "build"
	buildProdDir = buildDir + File.separator + "prod"
	vendorLibDir = "vendor" + File.separator + "lib"
	ant = new AntBuilder()

	void clean() {
		ant.delete(dir: buildDir)
	}

	void prepare() {
		clean()
		ant.mkdir(dir: buildProdDir)
	}

	void compile() {
		prepare()
		ant.javac(srcdir: srcDir, destDir: buildProdDir, classpath: projectClasspath())
	}

	String projectClasspath() {
		ant.path {
			fileset(dir: vendorLibDir) {
				include(name: "**/*.jar")
			}
		}
	}
}

new Build().compile()

