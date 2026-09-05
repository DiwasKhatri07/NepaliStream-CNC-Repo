package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Element;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeDudefilms$lambda$0$2$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeDudefilms$lambda$0$2$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0149xebbf8dff extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0149xebbf8dff(int i, Iterable iterable, Continuation continuation, Function1 function1, Function1 function2, Integer num) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
        this.$episode$inlined = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0149xebbf8dff = new C0149xebbf8dff(this.$concurrency, this.$this_runCatching, continuation, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        c0149xebbf8dff.L$0 = obj;
        return c0149xebbf8dff;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeDudefilms$lambda$0$2$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeDudefilms$lambda$0$2$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {2266, 2271, 2277}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "aTag", "source", "$this$withPermit$iv", "$completion", "aTag", "source", "epSource"}, nl = {2267, 2272, 2278}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2279\n5167#3,5:2269\n5172#3,4:2275\n1#4:2274\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2279,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1, Function1 function2, Integer num) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
            this.$episode$inlined = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0120 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x0121  */
        /* JADX WARN: Code duplicated, block: B:36:0x013e A[Catch: all -> 0x01ea, Exception -> 0x01f0, TryCatch #1 {Exception -> 0x01f0, blocks: (B:33:0x0126, B:34:0x0138, B:36:0x013e, B:38:0x015d, B:40:0x0163, B:42:0x016c, B:45:0x0173, B:49:0x017d, B:51:0x0182), top: B:85:0x0126 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x015d A[Catch: all -> 0x01ea, Exception -> 0x01f0, TryCatch #1 {Exception -> 0x01f0, blocks: (B:33:0x0126, B:34:0x0138, B:36:0x013e, B:38:0x015d, B:40:0x0163, B:42:0x016c, B:45:0x0173, B:49:0x017d, B:51:0x0182), top: B:85:0x0126 }] */
        /* JADX WARN: Code duplicated, block: B:43:0x0171  */
        /* JADX WARN: Code duplicated, block: B:51:0x0182 A[Catch: all -> 0x01ea, Exception -> 0x01f0, TryCatch #1 {Exception -> 0x01f0, blocks: (B:33:0x0126, B:34:0x0138, B:36:0x013e, B:38:0x015d, B:40:0x0163, B:42:0x016c, B:45:0x0173, B:49:0x017d, B:51:0x0182), top: B:85:0x0126 }] */
        /* JADX WARN: Code duplicated, block: B:61:0x01db A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:97:0x017c A[SYNTHETIC] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object obj;
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            int i;
            Semaphore $this$withPermit$iv3;
            Integer num;
            int i2;
            Object obj2;
            Continuation $completion;
            int i3;
            String source;
            Object obj3;
            Semaphore $this$withPermit$iv4;
            Element aTag;
            Semaphore semaphore;
            String str;
            Integer num2;
            Object obj4;
            String source2;
            Object obj5;
            Semaphore $this$withPermit$iv5;
            Iterator it;
            Object next;
            Element element;
            Object obj6;
            String epSource;
            Object obj7;
            MatchResult matchResultFind$default;
            Integer intOrNull;
            List groupValues;
            AnonymousClass1 anonymousClass1 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (anonymousClass1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv6 = anonymousClass1.$semaphore;
                    obj = anonymousClass1.$item;
                    anonymousClass1.L$0 = $this$withPermit$iv6;
                    anonymousClass1.L$1 = obj;
                    anonymousClass1.label = 1;
                    if ($this$withPermit$iv6.acquire((Continuation) anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv6;
                    $this$withPermit$iv2 = null;
                    i = 0;
                    try {
                        Element aTag2 = (Element) obj;
                        $completion = (Continuation) anonymousClass1;
                        i3 = 0;
                        source = aTag2.attr("href");
                        Log.INSTANCE.d("Dudefilms", "source: " + source);
                        Requests app = MainActivityKt.getApp();
                        anonymousClass1.L$0 = $this$withPermit$iv;
                        anonymousClass1.L$1 = obj;
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(aTag2);
                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(source);
                        anonymousClass1.label = 2;
                        obj3 = obj;
                        $this$withPermit$iv4 = $this$withPermit$iv;
                        num = null;
                        aTag = aTag2;
                        semaphore = $this$withPermit$iv2;
                        str = "href";
                        num2 = null;
                        try {
                            obj4 = Requests.get$default(app, source, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                            anonymousClass1 = this;
                            if (obj4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            source2 = source;
                            obj5 = obj3;
                            $this$withPermit$iv5 = $this$withPermit$iv4;
                            try {
                                try {
                                    it = ((NiceResponse) obj4).getDocument().select("a.maxbutton").iterator();
                                    try {
                                        do {
                                            if (it.hasNext()) {
                                                next = it.next();
                                                Element it2 = (Element) next;
                                                matchResultFind$default = Regex.find$default(new Regex("(?:Episode|Ep|E)\\s*(\\d+)", RegexOption.IGNORE_CASE), it2.text(), 0, 2, num2);
                                                if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                                                    String str2 = (String) CollectionsKt.getOrNull(groupValues, 1);
                                                    if (str2 != null) {
                                                        intOrNull = StringsKt.toIntOrNull(str2);
                                                    }
                                                }
                                            } else {
                                                next = num2;
                                            }
                                            element = (Element) next;
                                            if (element != null || (epSource = element.attr(str)) == null) {
                                                obj6 = Unit.INSTANCE;
                                                $this$withPermit$iv5.release();
                                                return obj6;
                                            }
                                            Function1 function1 = anonymousClass1.$subtitleCallback$inlined;
                                            Function1 function2 = anonymousClass1.$callback$inlined;
                                            anonymousClass1.L$0 = $this$withPermit$iv5;
                                            anonymousClass1.L$1 = obj5;
                                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(aTag);
                                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(source2);
                                            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(epSource);
                                            anonymousClass1.label = 3;
                                            Object objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("Dudefilms", epSource, "", function1, function2, null, null, anonymousClass1, 96, null);
                                            if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            $this$withPermit$iv3 = $this$withPermit$iv5;
                                            i2 = i;
                                            obj7 = objLoadSourceNameExtractor$default;
                                            obj6 = obj7;
                                            $this$withPermit$iv5 = $this$withPermit$iv3;
                                            $this$withPermit$iv5.release();
                                            return obj6;
                                        } while (!Intrinsics.areEqual(intOrNull, anonymousClass1.$episode$inlined));
                                        if (element != null) {
                                        }
                                        obj6 = Unit.INSTANCE;
                                    } catch (Exception e) {
                                        e = e;
                                        obj2 = obj5;
                                        $this$withPermit$iv3 = $this$withPermit$iv5;
                                        i2 = i;
                                        $this$withPermit$iv2 = semaphore;
                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                        $this$withPermit$iv5 = $this$withPermit$iv3;
                                        obj6 = num;
                                    }
                                    element = (Element) next;
                                } catch (Exception e2) {
                                    e = e2;
                                    num = num2;
                                    obj2 = obj5;
                                    $this$withPermit$iv3 = $this$withPermit$iv5;
                                    i2 = i;
                                    $this$withPermit$iv2 = semaphore;
                                }
                                $this$withPermit$iv5.release();
                                return obj6;
                            } catch (Throwable th) {
                                th = th;
                                $this$withPermit$iv3 = $this$withPermit$iv5;
                                $this$withPermit$iv3.release();
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            num = null;
                            i2 = 0;
                            obj2 = obj3;
                            $this$withPermit$iv3 = $this$withPermit$iv4;
                            $this$withPermit$iv2 = semaphore;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            $this$withPermit$iv5 = $this$withPermit$iv3;
                            obj6 = num;
                            $this$withPermit$iv5.release();
                            return obj6;
                        } catch (Throwable th2) {
                            th = th2;
                            $this$withPermit$iv3 = $this$withPermit$iv4;
                            $this$withPermit$iv3.release();
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        num = null;
                        i2 = 0;
                        obj2 = obj;
                        $this$withPermit$iv3 = $this$withPermit$iv;
                    } catch (Throwable th3) {
                        th = th3;
                        $this$withPermit$iv3 = $this$withPermit$iv;
                    }
                    break;
                case 1:
                    $this$withPermit$iv2 = null;
                    obj = anonymousClass1.L$1;
                    $this$withPermit$iv = (Semaphore) anonymousClass1.L$0;
                    ResultKt.throwOnFailure($result);
                    i = 0;
                    Element aTag3 = (Element) obj;
                    $completion = (Continuation) anonymousClass1;
                    i3 = 0;
                    source = aTag3.attr("href");
                    Log.INSTANCE.d("Dudefilms", "source: " + source);
                    Requests app2 = MainActivityKt.getApp();
                    anonymousClass1.L$0 = $this$withPermit$iv;
                    anonymousClass1.L$1 = obj;
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(aTag3);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(source);
                    anonymousClass1.label = 2;
                    obj3 = obj;
                    $this$withPermit$iv4 = $this$withPermit$iv;
                    num = null;
                    aTag = aTag3;
                    semaphore = $this$withPermit$iv2;
                    str = "href";
                    num2 = null;
                    obj4 = Requests.get$default(app2, source, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                    anonymousClass1 = this;
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    source2 = source;
                    obj5 = obj3;
                    $this$withPermit$iv5 = $this$withPermit$iv4;
                    it = ((NiceResponse) obj4).getDocument().select("a.maxbutton").iterator();
                    do {
                        if (it.hasNext()) {
                            next = it.next();
                            Element it3 = (Element) next;
                            matchResultFind$default = Regex.find$default(new Regex("(?:Episode|Ep|E)\\s*(\\d+)", RegexOption.IGNORE_CASE), it3.text(), 0, 2, num2);
                            intOrNull = matchResultFind$default == null ? num2 : num2;
                        } else {
                            next = num2;
                        }
                        element = (Element) next;
                        if (element != null) {
                        }
                        obj6 = Unit.INSTANCE;
                        $this$withPermit$iv5.release();
                        return obj6;
                    } while (!Intrinsics.areEqual(intOrNull, anonymousClass1.$episode$inlined));
                    element = (Element) next;
                    if (element != null) {
                    }
                    obj6 = Unit.INSTANCE;
                    $this$withPermit$iv5.release();
                    return obj6;
                case 2:
                    $this$withPermit$iv2 = null;
                    String source3 = (String) anonymousClass1.L$4;
                    Element aTag4 = (Element) anonymousClass1.L$3;
                    Continuation $completion2 = (Continuation) anonymousClass1.L$2;
                    obj5 = anonymousClass1.L$1;
                    $this$withPermit$iv5 = (Semaphore) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj4 = $result;
                        semaphore = null;
                        str = "href";
                        num2 = null;
                        i = 0;
                        i3 = 0;
                        aTag = aTag4;
                        $completion = $completion2;
                        source2 = source3;
                        it = ((NiceResponse) obj4).getDocument().select("a.maxbutton").iterator();
                        do {
                            if (it.hasNext()) {
                                next = it.next();
                                Element it4 = (Element) next;
                                matchResultFind$default = Regex.find$default(new Regex("(?:Episode|Ep|E)\\s*(\\d+)", RegexOption.IGNORE_CASE), it4.text(), 0, 2, num2);
                                if (matchResultFind$default == null) {
                                }
                            } else {
                                next = num2;
                            }
                            element = (Element) next;
                            if (element != null) {
                            }
                            obj6 = Unit.INSTANCE;
                            $this$withPermit$iv5.release();
                            return obj6;
                        } while (!Intrinsics.areEqual(intOrNull, anonymousClass1.$episode$inlined));
                        element = (Element) next;
                        if (element != null) {
                        }
                        obj6 = Unit.INSTANCE;
                    } catch (Exception e5) {
                        e = e5;
                        num = null;
                        i2 = 0;
                        obj2 = obj5;
                        $this$withPermit$iv3 = $this$withPermit$iv5;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        $this$withPermit$iv5 = $this$withPermit$iv3;
                        obj6 = num;
                        $this$withPermit$iv5.release();
                        return obj6;
                    } catch (Throwable th4) {
                        th = th4;
                        $this$withPermit$iv3 = $this$withPermit$iv5;
                        $this$withPermit$iv3.release();
                        throw th;
                    }
                    $this$withPermit$iv5.release();
                    return obj6;
                case 3:
                    $this$withPermit$iv2 = null;
                    i2 = 0;
                    obj2 = anonymousClass1.L$1;
                    $this$withPermit$iv3 = (Semaphore) anonymousClass1.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            obj7 = $result;
                            obj6 = obj7;
                            $this$withPermit$iv5 = $this$withPermit$iv3;
                        } catch (Exception e6) {
                            e = e6;
                            num = null;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            $this$withPermit$iv5 = $this$withPermit$iv3;
                            obj6 = num;
                        }
                        $this$withPermit$iv5.release();
                        return obj6;
                    } catch (Throwable th5) {
                        th = th5;
                        $this$withPermit$iv3.release();
                        throw th;
                    }
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined), 2, (Object) null));
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
