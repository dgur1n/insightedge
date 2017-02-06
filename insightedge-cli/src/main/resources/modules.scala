import org.gigaspaces.cli.core.moduleRegistry
import org.gigaspaces.cli.core.helpMain.help
import org.gigaspaces.xap.cli.XapGrid

moduleRegistry.register("grid", new XapGrid())
