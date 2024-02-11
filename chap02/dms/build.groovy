import java.io.File

class Build {
	def srcDir = "src"
	def buildDir = "build"
	def buildProdDir = buildDir + File.separator + "prod"
	def vendorLibDir = "vendor" + File.separator + "lib"
	def ant = new AntBuilder()

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

