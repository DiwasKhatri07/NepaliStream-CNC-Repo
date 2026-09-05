package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Integer $season$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Integer num, Integer num2, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$season$inlined = num;
        this.$episode$inlined = num2;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Object>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeDudefilms$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {2266, 2270, 2278, 2293}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "it", "url", "$this$withPermit$iv", "$completion", "it", "url", "doc", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv", "$this$withPermit$iv", "$completion", "it", "url", "doc", "matchingH4Tags", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2272, 2279, 2294}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2297\n5382#3,5:2269\n5394#3:2281\n5395#3:2284\n5398#3,3:2286\n5423#3:2296\n1880#4,5:2274\n1899#4,2:2279\n1880#4,5:2289\n1899#4,2:2294\n777#5:2282\n873#5:2283\n874#5:2285\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2297,2\n5386#2:2274,5\n5386#2:2279,2\n5400#2:2289,5\n5400#2:2294,2\n5394#2:2282\n5394#2:2283\n5394#2:2285\n*E\n"})
    public static final class C01461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Integer $season$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01461(Semaphore semaphore, Object obj, Continuation continuation, Integer num, Integer num2, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$season$inlined = num;
            this.$episode$inlined = num2;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01461(this.$semaphore, this.$item, continuation, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:150:0x026f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x0158 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x0159  */
        /* JADX WARN: Code duplicated, block: B:38:0x016d A[Catch: all -> 0x033b, Exception -> 0x0341, TryCatch #17 {Exception -> 0x0341, all -> 0x033b, blocks: (B:36:0x0162, B:38:0x016d, B:40:0x0171, B:62:0x0212, B:63:0x0228, B:65:0x022e, B:67:0x026c, B:69:0x0276, B:71:0x0287, B:72:0x028b), top: B:147:0x0162 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x022e A[Catch: all -> 0x033b, Exception -> 0x0341, TryCatch #17 {Exception -> 0x0341, all -> 0x033b, blocks: (B:36:0x0162, B:38:0x016d, B:40:0x0171, B:62:0x0212, B:63:0x0228, B:65:0x022e, B:67:0x026c, B:69:0x0276, B:71:0x0287, B:72:0x028b), top: B:147:0x0162 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x026c A[Catch: all -> 0x033b, Exception -> 0x0341, TryCatch #17 {Exception -> 0x0341, all -> 0x033b, blocks: (B:36:0x0162, B:38:0x016d, B:40:0x0171, B:62:0x0212, B:63:0x0228, B:65:0x022e, B:67:0x026c, B:69:0x0276, B:71:0x0287, B:72:0x028b), top: B:147:0x0162 }] */
        /* JADX WARN: Code duplicated, block: B:71:0x0287 A[Catch: all -> 0x033b, Exception -> 0x0341, TryCatch #17 {Exception -> 0x0341, all -> 0x033b, blocks: (B:36:0x0162, B:38:0x016d, B:40:0x0171, B:62:0x0212, B:63:0x0228, B:65:0x022e, B:67:0x026c, B:69:0x0276, B:71:0x0287, B:72:0x028b), top: B:147:0x0162 }] */
        /* JADX WARN: Code duplicated, block: B:72:0x028b A[Catch: all -> 0x033b, Exception -> 0x0341, TRY_LEAVE, TryCatch #17 {Exception -> 0x0341, all -> 0x033b, blocks: (B:36:0x0162, B:38:0x016d, B:40:0x0171, B:62:0x0212, B:63:0x0228, B:65:0x022e, B:67:0x026c, B:69:0x0276, B:71:0x0287, B:72:0x028b), top: B:147:0x0162 }] */
        /* JADX WARN: Code duplicated, block: B:78:0x02f2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:79:0x02f3  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Object obj;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv2;
            int $i$f$withPermit2;
            Object obj2;
            Continuation $completion;
            Element it;
            String url;
            Object obj3;
            Semaphore $this$withPermit$iv3;
            Object obj4;
            C01461 c01461;
            String url2;
            Continuation $completion2;
            String url3;
            Object obj5;
            Element it2;
            Document doc;
            Iterable $this$filter$iv;
            int $i$f$filter;
            Collection destination$iv$iv;
            String str;
            List matchingH4Tags;
            Semaphore $this$withPermit$iv4;
            Object objCoroutineScope;
            Unit unit;
            Object obj6;
            Semaphore $this$withPermit$iv5;
            Object objCoroutineScope2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv6 = this.$semaphore;
                    Object obj7 = this.$item;
                    this.L$0 = $this$withPermit$iv6;
                    this.L$1 = obj7;
                    this.label = 1;
                    if ($this$withPermit$iv6.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv6;
                    obj = obj7;
                    $i$f$withPermit = 0;
                    try {
                        $completion = (Continuation) this;
                        it = (Element) obj;
                        url = it.attr("href");
                        Requests app = MainActivityKt.getApp();
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = obj;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(url);
                        this.label = 2;
                        obj3 = obj;
                        $this$withPermit$iv3 = $this$withPermit$iv;
                        try {
                            obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                            c01461 = this;
                            if (obj4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url2 = url;
                            $completion2 = $completion;
                            url3 = null;
                            obj5 = obj3;
                            it2 = it;
                            try {
                                doc = ((NiceResponse) obj4).getDocument();
                                if (c01461.$season$inlined == null || c01461.$episode$inlined != null) {
                                    $this$filter$iv = doc.select("h4");
                                    $i$f$filter = 0;
                                    destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv : $this$filter$iv) {
                                        Iterable $this$filter$iv2 = $this$filter$iv;
                                        String str2 = url3;
                                        int $i$f$filter2 = $i$f$filter;
                                        if (new Regex("Season\\s*0*" + c01461.$season$inlined + "\\b", RegexOption.IGNORE_CASE).containsMatchIn(((Element) element$iv$iv).text())) {
                                            destination$iv$iv.add(element$iv$iv);
                                        }
                                        $this$filter$iv = $this$filter$iv2;
                                        url3 = str2;
                                        $i$f$filter = $i$f$filter2;
                                    }
                                    str = url3;
                                    matchingH4Tags = (List) destination$iv$iv;
                                    if (matchingH4Tags.isEmpty()) {
                                        unit = Unit.INSTANCE;
                                    } else {
                                        List $this$safeAmap_u24default$iv = matchingH4Tags;
                                        try {
                                            Result.Companion companion = Result.Companion;
                                            try {
                                                C0149x2e121bf2 c0149x2e121bf2 = new C0149x2e121bf2(7, $this$safeAmap_u24default$iv, null, c01461.$subtitleCallback$inlined, c01461.$callback$inlined, c01461.$episode$inlined);
                                                c01461.L$0 = $this$withPermit$iv3;
                                                c01461.L$1 = obj5;
                                                c01461.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                                c01461.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                                                c01461.L$4 = SpillingKt.nullOutSpilledVariable(url2);
                                                c01461.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                                                c01461.L$6 = SpillingKt.nullOutSpilledVariable(matchingH4Tags);
                                                c01461.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                c01461.L$8 = SpillingKt.nullOutSpilledVariable(this);
                                                c01461.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                c01461.I$0 = 7;
                                                c01461.label = 4;
                                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0149x2e121bf2, c01461);
                                                if (objCoroutineScope == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                try {
                                                    Result.constructor-impl((List) objCoroutineScope);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    try {
                                                        Result.Companion companion2 = Result.Companion;
                                                        Result.constructor-impl(ResultKt.createFailure(th));
                                                    } catch (Exception e) {
                                                        e = e;
                                                        obj2 = obj5;
                                                        $this$withPermit$iv2 = $this$withPermit$iv4;
                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                        unit = null;
                                                        $this$withPermit$iv3 = $this$withPermit$iv2;
                                                        $this$withPermit$iv3.release();
                                                        return unit;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        $this$withPermit$iv2 = $this$withPermit$iv4;
                                                        $this$withPermit$iv2.release();
                                                        throw th;
                                                    }
                                                }
                                                obj2 = obj5;
                                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                                try {
                                                    try {
                                                        unit = Unit.INSTANCE;
                                                        $this$withPermit$iv3 = $this$withPermit$iv2;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                        unit = null;
                                                        $this$withPermit$iv3 = $this$withPermit$iv2;
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    $this$withPermit$iv2.release();
                                                    throw th;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                Result.Companion companion3 = Result.Companion;
                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                obj2 = obj5;
                                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                                unit = Unit.INSTANCE;
                                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                                $this$withPermit$iv3.release();
                                                return unit;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            $this$withPermit$iv4 = $this$withPermit$iv3;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                        }
                                    }
                                } else {
                                    Iterable $this$safeAmap_u24default$iv2 = doc.select("a.maxbutton");
                                    try {
                                        Result.Companion companion4 = Result.Companion;
                                        try {
                                            C0148x2e121bf1 c0148x2e121bf1 = new C0148x2e121bf1(7, $this$safeAmap_u24default$iv2, null, c01461.$subtitleCallback$inlined, c01461.$callback$inlined);
                                            c01461.L$0 = $this$withPermit$iv3;
                                            c01461.L$1 = obj5;
                                            c01461.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                            c01461.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                                            c01461.L$4 = SpillingKt.nullOutSpilledVariable(url2);
                                            c01461.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                                            c01461.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                            c01461.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                            c01461.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                                            c01461.I$0 = 7;
                                            c01461.label = 3;
                                            objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0148x2e121bf1, c01461);
                                            if (objCoroutineScope2 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            obj6 = obj5;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            $this$withPermit$iv5 = $this$withPermit$iv3;
                                            try {
                                                Result.constructor-impl((List) objCoroutineScope2);
                                            } catch (Throwable th6) {
                                                th = th6;
                                                try {
                                                    Result.Companion companion5 = Result.Companion;
                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    obj2 = obj6;
                                                    $this$withPermit$iv2 = $this$withPermit$iv5;
                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                    unit = null;
                                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                                    $this$withPermit$iv3.release();
                                                    return unit;
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    $this$withPermit$iv2 = $this$withPermit$iv5;
                                                    $this$withPermit$iv2.release();
                                                    throw th;
                                                }
                                            }
                                            obj2 = obj6;
                                            $this$withPermit$iv2 = $this$withPermit$iv5;
                                            unit = Unit.INSTANCE;
                                            $this$withPermit$iv3 = $this$withPermit$iv2;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            obj6 = obj5;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            $this$withPermit$iv5 = $this$withPermit$iv3;
                                            Result.Companion companion6 = Result.Companion;
                                            Result.constructor-impl(ResultKt.createFailure(th));
                                            obj2 = obj6;
                                            $this$withPermit$iv2 = $this$withPermit$iv5;
                                            unit = Unit.INSTANCE;
                                            $this$withPermit$iv3 = $this$withPermit$iv2;
                                            $this$withPermit$iv3.release();
                                            return unit;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        obj6 = obj5;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        $this$withPermit$iv5 = $this$withPermit$iv3;
                                    }
                                }
                                break;
                            } catch (Exception e4) {
                                e = e4;
                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                obj2 = obj5;
                                $i$f$withPermit2 = $i$f$withPermit;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                unit = null;
                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                $this$withPermit$iv3.release();
                                return unit;
                            } catch (Throwable th10) {
                                th = th10;
                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                $this$withPermit$iv2.release();
                                throw th;
                            }
                            $this$withPermit$iv3.release();
                            return unit;
                        } catch (Exception e5) {
                            e = e5;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            $i$f$withPermit2 = $i$f$withPermit;
                            obj2 = obj3;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            unit = null;
                            $this$withPermit$iv3 = $this$withPermit$iv2;
                            $this$withPermit$iv3.release();
                            return unit;
                        } catch (Throwable th11) {
                            th = th11;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        Object obj8 = obj;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                        $i$f$withPermit2 = $i$f$withPermit;
                        obj2 = obj8;
                    } catch (Throwable th12) {
                        th = th12;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                    break;
                case 1:
                    Object obj9 = this.L$1;
                    Semaphore $this$withPermit$iv7 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    obj = obj9;
                    $this$withPermit$iv = $this$withPermit$iv7;
                    $completion = (Continuation) this;
                    it = (Element) obj;
                    url = it.attr("href");
                    Requests app2 = MainActivityKt.getApp();
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(url);
                    this.label = 2;
                    obj3 = obj;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    obj4 = Requests.get$default(app2, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                    c01461 = this;
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url2 = url;
                    $completion2 = $completion;
                    url3 = null;
                    obj5 = obj3;
                    it2 = it;
                    doc = ((NiceResponse) obj4).getDocument();
                    if (c01461.$season$inlined == null) {
                        break;
                    }
                    $this$filter$iv = doc.select("h4");
                    $i$f$filter = 0;
                    destination$iv$iv = new ArrayList();
                    while (r9.hasNext()) {
                        Iterable $this$filter$iv3 = $this$filter$iv;
                        String str3 = url3;
                        int $i$f$filter3 = $i$f$filter;
                        if (new Regex("Season\\s*0*" + c01461.$season$inlined + "\\b", RegexOption.IGNORE_CASE).containsMatchIn(((Element) element$iv$iv).text())) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv3;
                        url3 = str3;
                        $i$f$filter = $i$f$filter3;
                    }
                    str = url3;
                    matchingH4Tags = (List) destination$iv$iv;
                    if (matchingH4Tags.isEmpty()) {
                        unit = Unit.INSTANCE;
                    } else {
                        List $this$safeAmap_u24default$iv3 = matchingH4Tags;
                        Result.Companion companion7 = Result.Companion;
                        C0149x2e121bf2 c0149x2e121bf3 = new C0149x2e121bf2(7, $this$safeAmap_u24default$iv3, null, c01461.$subtitleCallback$inlined, c01461.$callback$inlined, c01461.$episode$inlined);
                        c01461.L$0 = $this$withPermit$iv3;
                        c01461.L$1 = obj5;
                        c01461.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                        c01461.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                        c01461.L$4 = SpillingKt.nullOutSpilledVariable(url2);
                        c01461.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                        c01461.L$6 = SpillingKt.nullOutSpilledVariable(matchingH4Tags);
                        c01461.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                        c01461.L$8 = SpillingKt.nullOutSpilledVariable(this);
                        c01461.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                        c01461.I$0 = 7;
                        c01461.label = 4;
                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0149x2e121bf3, c01461);
                        if (objCoroutineScope == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv4 = $this$withPermit$iv3;
                        $i$f$withPermit2 = $i$f$withPermit;
                        Result.constructor-impl((List) objCoroutineScope);
                        obj2 = obj5;
                        $this$withPermit$iv2 = $this$withPermit$iv4;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv3 = $this$withPermit$iv2;
                    }
                    $this$withPermit$iv3.release();
                    return unit;
                case 2:
                    $i$f$withPermit2 = 0;
                    url3 = null;
                    String url4 = (String) this.L$4;
                    Element it3 = (Element) this.L$3;
                    Continuation $completion3 = (Continuation) this.L$2;
                    obj2 = this.L$1;
                    $this$withPermit$iv2 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        url2 = url4;
                        it2 = it3;
                        $completion2 = $completion3;
                        obj5 = obj2;
                        obj4 = $result;
                        c01461 = this;
                        $this$withPermit$iv3 = $this$withPermit$iv2;
                        doc = ((NiceResponse) obj4).getDocument();
                        if (c01461.$season$inlined == null) {
                        }
                        $this$filter$iv = doc.select("h4");
                        $i$f$filter = 0;
                        destination$iv$iv = new ArrayList();
                        while (r9.hasNext()) {
                            Iterable $this$filter$iv4 = $this$filter$iv;
                            String str4 = url3;
                            int $i$f$filter4 = $i$f$filter;
                            if (new Regex("Season\\s*0*" + c01461.$season$inlined + "\\b", RegexOption.IGNORE_CASE).containsMatchIn(((Element) element$iv$iv).text())) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                            $this$filter$iv = $this$filter$iv4;
                            url3 = str4;
                            $i$f$filter = $i$f$filter4;
                        }
                        str = url3;
                        matchingH4Tags = (List) destination$iv$iv;
                        if (matchingH4Tags.isEmpty()) {
                            unit = Unit.INSTANCE;
                        } else {
                            List $this$safeAmap_u24default$iv4 = matchingH4Tags;
                            Result.Companion companion8 = Result.Companion;
                            C0149x2e121bf2 c0149x2e121bf4 = new C0149x2e121bf2(7, $this$safeAmap_u24default$iv4, null, c01461.$subtitleCallback$inlined, c01461.$callback$inlined, c01461.$episode$inlined);
                            c01461.L$0 = $this$withPermit$iv3;
                            c01461.L$1 = obj5;
                            c01461.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                            c01461.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                            c01461.L$4 = SpillingKt.nullOutSpilledVariable(url2);
                            c01461.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                            c01461.L$6 = SpillingKt.nullOutSpilledVariable(matchingH4Tags);
                            c01461.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                            c01461.L$8 = SpillingKt.nullOutSpilledVariable(this);
                            c01461.L$9 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv4);
                            c01461.I$0 = 7;
                            c01461.label = 4;
                            objCoroutineScope = CoroutineScopeKt.coroutineScope(c0149x2e121bf4, c01461);
                            if (objCoroutineScope == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv4 = $this$withPermit$iv3;
                            $i$f$withPermit2 = $i$f$withPermit;
                            Result.constructor-impl((List) objCoroutineScope);
                            obj2 = obj5;
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv3 = $this$withPermit$iv2;
                        }
                        break;
                    } catch (Exception e7) {
                        e = e7;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        unit = null;
                        $this$withPermit$iv3 = $this$withPermit$iv2;
                        $this$withPermit$iv3.release();
                        return unit;
                    } catch (Throwable th13) {
                        th = th13;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                    $this$withPermit$iv3.release();
                    return unit;
                case 3:
                    $i$f$withPermit2 = 0;
                    int i = this.I$0;
                    obj6 = this.L$1;
                    $this$withPermit$iv5 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        objCoroutineScope2 = $result;
                        Result.constructor-impl((List) objCoroutineScope2);
                        break;
                    } catch (Throwable th14) {
                        th = th14;
                        Result.Companion companion9 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        obj2 = obj6;
                        $this$withPermit$iv2 = $this$withPermit$iv5;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv3 = $this$withPermit$iv2;
                        $this$withPermit$iv3.release();
                        return unit;
                    }
                    obj2 = obj6;
                    $this$withPermit$iv2 = $this$withPermit$iv5;
                    unit = Unit.INSTANCE;
                    $this$withPermit$iv3 = $this$withPermit$iv2;
                    $this$withPermit$iv3.release();
                    return unit;
                case 4:
                    $i$f$withPermit2 = 0;
                    int i2 = this.I$0;
                    doc = (Document) this.L$5;
                    url2 = (String) this.L$4;
                    it2 = (Element) this.L$3;
                    $completion2 = (Continuation) this.L$2;
                    obj5 = this.L$1;
                    $this$withPermit$iv4 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        str = null;
                        objCoroutineScope = $result;
                        Result.constructor-impl((List) objCoroutineScope);
                    } catch (Throwable th15) {
                        th = th15;
                        Result.Companion companion10 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        obj2 = obj5;
                        $this$withPermit$iv2 = $this$withPermit$iv4;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv3 = $this$withPermit$iv2;
                        $this$withPermit$iv3.release();
                        return unit;
                    }
                    obj2 = obj5;
                    $this$withPermit$iv2 = $this$withPermit$iv4;
                    unit = Unit.INSTANCE;
                    $this$withPermit$iv3 = $this$withPermit$iv2;
                    $this$withPermit$iv3.release();
                    return unit;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore semaphore = SemaphoreKt.Semaphore$default(this.$concurrency, 0, 2, (Object) null);
                Iterable $this$map$iv = this.$this_runCatching;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Collection destination$iv$iv2 = destination$iv$iv;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01461(semaphore, item$iv$iv, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
                    destination$iv$iv = destination$iv$iv2;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(semaphore);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwaitAll = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return CollectionsKt.filterNotNull((Iterable) objAwaitAll);
    }
}
