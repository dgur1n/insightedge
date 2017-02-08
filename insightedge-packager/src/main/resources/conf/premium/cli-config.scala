import org.gigaspaces.cli.core.moduleRegistry
import org.gigaspaces.cli.core.helpMain.help
import org.gigaspaces.insightedge.cli.IeGrid

val grid = new IeGrid()

moduleRegistry.register("grid", grid)
