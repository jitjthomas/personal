class FormatCategory {
    static leftAlign(self, width) {
        self.toString().padRight(width, ' ')
    }
    static leftAlign(self, width, filler) {
        self.toString().padRight(width, filler[0])
    }
    static rightAlign(self, width) {
        self.toString().padLeft(width, ' ')
    }
    static rightAlign(self, width, filler) {
        self.toString().padLeft(width, filler[0])
    }
}

use (FormatCategory) {
    println 'Peter'.leftAlign(15, '*') + 
	100.rightAlign(10, '0')
}