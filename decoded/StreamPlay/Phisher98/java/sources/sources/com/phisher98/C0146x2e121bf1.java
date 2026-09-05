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

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeDudefilms$lambda$0$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeDudefilms$lambda$0$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0146x2e121bf1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Unit>>>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0146x2e121bf1(int i, Iterable iterable, Continuation continuation, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0146x2e121bf1 = new C0146x2e121bf1(this.$concurrency, this.$this_runCatching, continuation, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0146x2e121bf1.L$0 = obj;
        return c0146x2e121bf1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Unit>>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeDudefilms$lambda$0$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeDudefilms$lambda$0$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2270, 2276}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "link", "href", "$this$withPermit$iv", "$completion", "link", "href", "document", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2271, 2277}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2280\n5146#3,3:2269\n5150#3:2279\n1880#4,5:2272\n1899#4,2:2277\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2280,2\n5148#2:2272,5\n5148#2:2277,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends Unit>>>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
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
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends Unit>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0113 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x0114  */
        /* JADX WARN: Code duplicated, block: B:37:0x0188 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x0189  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Object obj;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv2;
            Object obj2;
            Continuation $completion;
            Element link;
            String href;
            Semaphore $this$withPermit$iv3;
            Object obj3;
            Object obj4;
            AnonymousClass1 anonymousClass1;
            Semaphore $this$withPermit$iv4;
            String href2;
            Continuation $completion2;
            Object obj5;
            Element link2;
            Object objCoroutineScope;
            Object obj6;
            Result result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv5 = this.$semaphore;
                    Object obj7 = this.$item;
                    this.L$0 = $this$withPermit$iv5;
                    this.L$1 = obj7;
                    this.label = 1;
                    if ($this$withPermit$iv5.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv5;
                    obj = obj7;
                    $i$f$withPermit = 0;
                    try {
                        $completion = (Continuation) this;
                        link = (Element) obj;
                        href = link.attr("href");
                        Requests app = MainActivityKt.getApp();
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = obj;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(href);
                        this.label = 2;
                        $this$withPermit$iv3 = $this$withPermit$iv;
                        obj3 = obj;
                        try {
                            obj4 = Requests.get$default(app, href, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                            anonymousClass1 = this;
                            if (obj4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv4 = $this$withPermit$iv3;
                            href2 = href;
                            $completion2 = $completion;
                            obj5 = obj3;
                            link2 = link;
                            try {
                                Document document = ((NiceResponse) obj4).getDocument();
                                Iterable $this$safeAmap_u24default$iv = document.select("a.maxbutton");
                                try {
                                    Result.Companion companion = Result.Companion;
                                    try {
                                        C0148x991fc4fd c0148x991fc4fd = new C0148x991fc4fd(7, $this$safeAmap_u24default$iv, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                                        anonymousClass1.L$0 = $this$withPermit$iv4;
                                        anonymousClass1.L$1 = obj5;
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(href2);
                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(document);
                                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(this);
                                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                        anonymousClass1.I$0 = 7;
                                        anonymousClass1.label = 3;
                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0148x991fc4fd, anonymousClass1);
                                        if (objCoroutineScope == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj6 = Result.constructor-impl((List) objCoroutineScope);
                                        result = Result.box-impl(obj6);
                                        $this$withPermit$iv4.release();
                                        return result;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            e = e;
                                            obj2 = obj5;
                                            $this$withPermit$iv2 = $this$withPermit$iv4;
                                            try {
                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                result = null;
                                                $this$withPermit$iv4 = $this$withPermit$iv2;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                $this$withPermit$iv2.release();
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            $this$withPermit$iv2 = $this$withPermit$iv4;
                                            $this$withPermit$iv2.release();
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    Result.Companion companion3 = Result.Companion;
                                    obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                obj2 = obj5;
                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                result = null;
                                $this$withPermit$iv4 = $this$withPermit$iv2;
                            } catch (Throwable th5) {
                                th = th5;
                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                $this$withPermit$iv2.release();
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            obj2 = obj3;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            result = null;
                            $this$withPermit$iv4 = $this$withPermit$iv2;
                            $this$withPermit$iv4.release();
                            return result;
                        } catch (Throwable th6) {
                            th = th6;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                        obj2 = obj;
                    } catch (Throwable th7) {
                        th = th7;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                    }
                    break;
                case 1:
                    Object obj8 = this.L$1;
                    Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    obj = obj8;
                    $this$withPermit$iv = $this$withPermit$iv6;
                    $completion = (Continuation) this;
                    link = (Element) obj;
                    href = link.attr("href");
                    Requests app2 = MainActivityKt.getApp();
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(href);
                    this.label = 2;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    obj3 = obj;
                    obj4 = Requests.get$default(app2, href, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                    anonymousClass1 = this;
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv4 = $this$withPermit$iv3;
                    href2 = href;
                    $completion2 = $completion;
                    obj5 = obj3;
                    link2 = link;
                    Document document2 = ((NiceResponse) obj4).getDocument();
                    Iterable $this$safeAmap_u24default$iv2 = document2.select("a.maxbutton");
                    Result.Companion companion4 = Result.Companion;
                    C0148x991fc4fd c0148x991fc4fd2 = new C0148x991fc4fd(7, $this$safeAmap_u24default$iv2, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                    anonymousClass1.L$0 = $this$withPermit$iv4;
                    anonymousClass1.L$1 = obj5;
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(href2);
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(this);
                    anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                    anonymousClass1.I$0 = 7;
                    anonymousClass1.label = 3;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(c0148x991fc4fd2, anonymousClass1);
                    if (objCoroutineScope == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj6 = Result.constructor-impl((List) objCoroutineScope);
                    result = Result.box-impl(obj6);
                    $this$withPermit$iv4.release();
                    return result;
                case 2:
                    String href3 = (String) this.L$4;
                    Element link3 = (Element) this.L$3;
                    Continuation $completion3 = (Continuation) this.L$2;
                    obj2 = this.L$1;
                    $this$withPermit$iv2 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        href2 = href3;
                        link2 = link3;
                        $completion2 = $completion3;
                        obj5 = obj2;
                        $this$withPermit$iv4 = $this$withPermit$iv2;
                        obj4 = $result;
                        anonymousClass1 = this;
                        Document document3 = ((NiceResponse) obj4).getDocument();
                        Iterable $this$safeAmap_u24default$iv3 = document3.select("a.maxbutton");
                        Result.Companion companion5 = Result.Companion;
                        C0148x991fc4fd c0148x991fc4fd3 = new C0148x991fc4fd(7, $this$safeAmap_u24default$iv3, null, anonymousClass1.$subtitleCallback$inlined, anonymousClass1.$callback$inlined);
                        anonymousClass1.L$0 = $this$withPermit$iv4;
                        anonymousClass1.L$1 = obj5;
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(href2);
                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(document3);
                        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                        anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(this);
                        anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                        anonymousClass1.I$0 = 7;
                        anonymousClass1.label = 3;
                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0148x991fc4fd3, anonymousClass1);
                        if (objCoroutineScope == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj6 = Result.constructor-impl((List) objCoroutineScope);
                        result = Result.box-impl(obj6);
                        $this$withPermit$iv4.release();
                        return result;
                    } catch (Exception e5) {
                        e = e5;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        result = null;
                        $this$withPermit$iv4 = $this$withPermit$iv2;
                        $this$withPermit$iv4.release();
                        return result;
                    } catch (Throwable th8) {
                        th = th8;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                case 3:
                    int i = this.I$0;
                    obj5 = this.L$1;
                    $this$withPermit$iv4 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        objCoroutineScope = $result;
                        obj6 = Result.constructor-impl((List) objCoroutineScope);
                    } catch (Throwable th9) {
                        th = th9;
                        Result.Companion companion6 = Result.Companion;
                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    result = Result.box-impl(obj6);
                    $this$withPermit$iv4.release();
                    return result;
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
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
