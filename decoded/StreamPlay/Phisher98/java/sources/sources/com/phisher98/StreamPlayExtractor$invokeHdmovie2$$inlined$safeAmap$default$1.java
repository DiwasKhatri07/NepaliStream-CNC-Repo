package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Unit>>>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ String $type$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, String str, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$type$inlined = str;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$type$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Result<? extends List<? extends Unit>>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeHdmovie2$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2269, 2275}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "anchor", "$this$withPermit$iv", "$completion", "anchor", "innerDoc", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2270, 2276}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2279\n3708#3,2:2269\n3724#3:2278\n1880#4,5:2271\n1899#4,2:2276\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2279,2\n3709#2:2271,5\n3709#2:2276,2\n*E\n"})
    public static final class C01591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends Unit>>>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        final /* synthetic */ String $type$inlined;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01591(Semaphore semaphore, Object obj, Continuation continuation, String str, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$type$inlined = str;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01591(this.$semaphore, this.$item, continuation, this.$type$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends Unit>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00c7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:34:0x0138 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x0139  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            int $i$f$withPermit;
            Object obj;
            Object obj2;
            Semaphore $this$withPermit$iv3;
            Continuation $completion;
            Element anchor;
            Object objSafeGet$default;
            Element anchor2;
            Semaphore $this$withPermit$iv4;
            Object obj3;
            Continuation $completion2;
            Object objCoroutineScope;
            Object obj4;
            Result result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv5 = this.$semaphore;
                        Object obj5 = this.$item;
                        this.L$0 = $this$withPermit$iv5;
                        this.L$1 = obj5;
                        this.label = 1;
                        if ($this$withPermit$iv5.acquire((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv2 = $this$withPermit$iv5;
                        $i$f$withPermit = 0;
                        obj = obj5;
                        try {
                            $completion = (Continuation) this;
                            anchor = (Element) obj;
                            String strAttr = anchor.attr("href");
                            this.L$0 = $this$withPermit$iv2;
                            this.L$1 = obj;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(anchor);
                            this.label = 2;
                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr, null, null, null, null, false, 0, this, 126, null);
                            if (objSafeGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anchor2 = anchor;
                            $this$withPermit$iv4 = $this$withPermit$iv2;
                            obj3 = obj;
                            $completion2 = $completion;
                            try {
                                Document innerDoc = ((NiceResponse) objSafeGet$default).getDocument();
                                Iterable $this$safeAmap_u24default$iv = innerDoc.select("div > p > a");
                                try {
                                    Result.Companion companion = Result.Companion;
                                    try {
                                        C0161x25f1131f c0161x25f1131f = new C0161x25f1131f(7, $this$safeAmap_u24default$iv, null, this.$type$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                        this.L$0 = $this$withPermit$iv4;
                                        this.L$1 = obj3;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(anchor2);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(innerDoc);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                        this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                                        this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                        this.I$0 = 7;
                                        this.label = 3;
                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0161x25f1131f, this);
                                        if (objCoroutineScope == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj4 = Result.constructor-impl((List) objCoroutineScope);
                                        $this$withPermit$iv3 = $this$withPermit$iv4;
                                        try {
                                            result = Result.box-impl(obj4);
                                            break;
                                        } catch (Exception e) {
                                            e = e;
                                            obj2 = obj3;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            result = null;
                                        }
                                        $this$withPermit$iv3.release();
                                        return result;
                                    } catch (Throwable th) {
                                        th = th;
                                        Result.Companion companion2 = Result.Companion;
                                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                obj2 = obj3;
                                $this$withPermit$iv3 = $this$withPermit$iv4;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                result = null;
                                $this$withPermit$iv3.release();
                                return result;
                            } catch (Throwable th3) {
                                th = th3;
                                $this$withPermit$iv = $this$withPermit$iv4;
                                $this$withPermit$iv.release();
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            obj2 = obj;
                            $this$withPermit$iv3 = $this$withPermit$iv2;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            result = null;
                            $this$withPermit$iv3.release();
                            return result;
                        } catch (Throwable th4) {
                            th = th4;
                            $this$withPermit$iv = $this$withPermit$iv2;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        break;
                        break;
                    case 1:
                        Object obj6 = this.L$1;
                        Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        obj = obj6;
                        $completion = (Continuation) this;
                        anchor = (Element) obj;
                        String strAttr2 = anchor.attr("href");
                        this.L$0 = $this$withPermit$iv2;
                        this.L$1 = obj;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(anchor);
                        this.label = 2;
                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr2, null, null, null, null, false, 0, this, 126, null);
                        if (objSafeGet$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anchor2 = anchor;
                        $this$withPermit$iv4 = $this$withPermit$iv2;
                        obj3 = obj;
                        $completion2 = $completion;
                        Document innerDoc2 = ((NiceResponse) objSafeGet$default).getDocument();
                        Iterable $this$safeAmap_u24default$iv2 = innerDoc2.select("div > p > a");
                        Result.Companion companion3 = Result.Companion;
                        C0161x25f1131f c0161x25f1131f2 = new C0161x25f1131f(7, $this$safeAmap_u24default$iv2, null, this.$type$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                        this.L$0 = $this$withPermit$iv4;
                        this.L$1 = obj3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(anchor2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(innerDoc2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                        this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv2);
                        this.I$0 = 7;
                        this.label = 3;
                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0161x25f1131f2, this);
                        if (objCoroutineScope == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj4 = Result.constructor-impl((List) objCoroutineScope);
                        $this$withPermit$iv3 = $this$withPermit$iv4;
                        result = Result.box-impl(obj4);
                        $this$withPermit$iv3.release();
                        return result;
                    case 2:
                        Element anchor3 = (Element) this.L$3;
                        Continuation $completion3 = (Continuation) this.L$2;
                        obj2 = this.L$1;
                        $this$withPermit$iv3 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            anchor2 = anchor3;
                            $completion2 = $completion3;
                            obj3 = obj2;
                            $this$withPermit$iv4 = $this$withPermit$iv3;
                            objSafeGet$default = $result;
                            Document innerDoc3 = ((NiceResponse) objSafeGet$default).getDocument();
                            Iterable $this$safeAmap_u24default$iv3 = innerDoc3.select("div > p > a");
                            Result.Companion companion4 = Result.Companion;
                            C0161x25f1131f c0161x25f1131f3 = new C0161x25f1131f(7, $this$safeAmap_u24default$iv3, null, this.$type$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                            this.L$0 = $this$withPermit$iv4;
                            this.L$1 = obj3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(anchor2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(innerDoc3);
                            this.L$5 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(this);
                            this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv3);
                            this.I$0 = 7;
                            this.label = 3;
                            objCoroutineScope = CoroutineScopeKt.coroutineScope(c0161x25f1131f3, this);
                            if (objCoroutineScope == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = Result.constructor-impl((List) objCoroutineScope);
                            $this$withPermit$iv3 = $this$withPermit$iv4;
                            result = Result.box-impl(obj4);
                            $this$withPermit$iv3.release();
                            return result;
                        } catch (Exception e4) {
                            e = e4;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            result = null;
                            $this$withPermit$iv3.release();
                            return result;
                        }
                    case 3:
                        int i = this.I$0;
                        obj3 = this.L$1;
                        $this$withPermit$iv4 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            objCoroutineScope = $result;
                            obj4 = Result.constructor-impl((List) objCoroutineScope);
                            break;
                        } catch (Throwable th5) {
                            th = th5;
                            Result.Companion companion5 = Result.Companion;
                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                            break;
                        }
                        $this$withPermit$iv3 = $this$withPermit$iv4;
                        result = Result.box-impl(obj4);
                        $this$withPermit$iv3.release();
                        return result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th6) {
                th = th6;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01591(semaphore, item$iv$iv, null, this.$type$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
