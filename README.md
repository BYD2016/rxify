
# Rxify

Started with a simple demo for the talk at [droidconIN 2016, Banglore](https://droidconin.talkfunnel.com/2016/94-rxify-a-simple-spell-for-complex-rxjava-operators). Added more examples from [GDG New Delhi Meetup](https://www.facebook.com/events/1846568045632997/). 
Will keep adding more demos and new things here :)
 - For more information, checkout multi-part `Rxify` blog series on [medium](https://medium.com/@ragdroid/rxify-a-simple-spell-for-complex-rxjava-operators-part-1-4c31921583c4#.6hxqs39e6).
 - For the video of this talk click [here](https://www.youtube.com/watch?v=UTyPMjfO1cA&list=PL279M8GbNsevRo-PUq-9UrfJgFAIK6ONd&index=4)
 - For the slides click [here](https://speakerdeck.com/ragdroid/rxify-a-simple-spell-for-complex-rxjava-operators)
 - Slides for the Codelab can be found [here](https://speakerdeck.com/ragdroid/rxify-a-talk-to-remember-codelab)
 
## Project Structure

This project :

 - Uses RxJava2 for the demos.
 - Follows the `MVP` architecture inspired by [repository](https://github.com/googlesamples/android-architecture).
 - Makes use of [`Dagger2`](https://google.github.io/dagger/)
 - Uses [Butterknife](http://jakewharton.github.io/butterknife/)
 - Uses `TestScheduler` for writing tests.
 
## Zip-yosa ([`ZipActivity`](https://github.com/ragdroid/rxify/blob/master/app/src/main/java/com/ragdroid/rxify/zip/ZipActivity.java))

  Perform API calls asynchronously and wait for the result of both the calls to combine the result.
  For more information, checkout this [article](https://medium.com/@ragdroid/rxify-a-simple-spell-for-complex-rxjava-operators-part-1-4c31921583c4#.6hxqs39e6).

 - We are waiting for `FluxWeed` API call. 
 - We are also waiting for `Student` API call to get hair of Crab. 
 - Both the calls executing asynchronously. 
 - Problem : 
    - Initialise `PolyJuice` from the results of API calls. 
    - Hide the loader after both calls have completed.

    Here's the demo :

    ![Here's the demo](https://github.com/ragdroid/rxify/raw/master/images/Zipyosa.gif)

    
## Preserving Order in AutoComplete-Search ([`LibraryActivity`](https://github.com/ragdroid/rxify/blob/master/app/src/main/java/com/ragdroid/rxify/library/LibraryActivity.java))

  Depicting the problem of Ordering the results in Auto-Search and solving it using concatMap().
  For more information, checkout this [article](https://medium.com/@ragdroid/rxify-maintaining-order-in-auto-complete-search-d5c46ba26578#.f367qiy0u)

 - Perform Auto-Complete Search using `flatMap()` - results in unordered results
 - Toggle state to fix it using `concatMap()`
 - used `BookDataSource` and calling `getBooks(query)` on the data source return the results after a delay which is
    inversely proportional to the length of query string. - this is done to depict the ordering problem
 - used the open-source library used at my current company [Fueled](https://fueled.com/) - [reclaim](https://github.com/Fueled/reclaim) which
    extracts the boiler plate for creation of recyclerview adapter, implementation of MVP for listview items.

 Using `flatMap()` - Order is not maintained.

 ![Using `flatMap()`](https://github.com/ragdroid/rxify/raw/master/images/Buggy.gif)

 Using `concatMap()` - Order is maintained.

 ![Using `concatMap()`](https://github.com/ragdroid/rxify/raw/master/images/Fixy.gif)

Ordering problem is fixed, but we shouldn't be updating the list this frequently. 
`switchMap()` will improve the results even further :

 Using `switchMap()` - Order is maintained.

 ![Using `switchMap()`](https://github.com/ragdroid/rxify/raw/master/images/SwitchMap.gif)


## Code-lab 
This is the code-lab I conducted at the GDG New Delhi January meetup. SpeakerDeck for this is available [here](https://speakerdeck.com/ragdroid/rxify-a-talk-to-remember-codelab). Completed examples for all the operators are also available on the `master` branch. For in-detail commit-by-commit codelab. Refer to the [`codelab` branch](https://github.com/ragdroid/rxify/tree/codelab).

### Pre-requisites :
 - Android Studio IDE
 - `git`
 - Lots of excitement.

### Let's Get Started

 - Switch to branch `codelab`.
 - Checkout at the starting commit : SHA - `d5db64950f1616c308bb8174bb8dc01ab69971e8`.
 - List of all the commits is [here](https://github.com/ragdroid/rxify/commits/codelab).
 - Open `ChillActivity` and switch to the desired presenter.
 - Let's Get Started!! Following Excercises are available :

 #### Section 1 - Basic Spells :
 	
 - [`EmptyPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/EmptyPresenter.java)
 - [`ErrorPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/ErrorPresenter.java)
 - [`FromPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/FromPresenter.java)
 - [`IntervalPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/IntervalPresenter.java)
 - [`IntervalRangePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/IntervalRangePresenter.java)
 - [`JustPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/JustPresenter.java)
 - [`NeverPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/NeverPresenter.java)
 - [`RangePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/RangePresenter.java)
 - [`TimerPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter/TimerPresenter.java) 

 #### Section 2 - To-Do Section :
 	
 - [`AssignmentPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/AssignmentPresenter.java)
 - [`BattleFlowPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/BattleFlowPresenter.java)
 - [`BattlePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/BattlePresenter.java)
 - [`DistinctPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/DistinctPresenter.java)
 - [`FilterPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/FilterPresenter.java)
 - [`FlatMapPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/FlatMapPresenter.java)
 - [`MapPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/MapPresenter.java)
 - [`ReducePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/ReducePresenter.java)
 - [`SkipPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/SkipPresenter.java)
 - [`TakePresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/TakePresenter.java)
 - [`TakeUntilPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/TakeUntilPresenter.java)

 #### Section 3 - Threading :
	
 - [`ThreadingPresenter`](app/src/main/java/com/ragdroid/rxify/codelab/presenter2/ThreadingPresenter.java)

 #### Section 4 - Testing :
	
 - [`EmptyPresenter`](app/src/test/java/com/ragdroid/rxify/codelab/presenter/EmptyPresenterTest.java)
 - [`NeverPresenter`](app/src/test/java/com/ragdroid/rxify/codelab/presenter/NeverPresenterTest.java)
 - [`MagicalRemoteDataSourceTest`](app/src/test/java/com/ragdroid/rxify/logic/data/remote/MagicalRemoteDataSourceTest.java)


## TO-DO
 - Implement more demos.
