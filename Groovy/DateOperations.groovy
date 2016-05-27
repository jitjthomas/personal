Date today = new Date()
tomorrow = today + 1
yesterday = today - 1
assert tomorrow.after(today)
assert yesterday.before(today)
assert (tomorrow <=> yesterday) > 0
println "Tomorrow = " + tomorrow
println "Yesterday = " + yesterday

use( groovy.time.TimeCategory ){
today = new Date()
println today + 1.days
println today - 3.months
println today + 4.years
}

