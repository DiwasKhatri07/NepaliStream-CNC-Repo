package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeFilmyfiy$lambda$1$1$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeFilmyfiy$lambda$1$1$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0153x4a43e4c3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Boolean>>, Object> {
    final /* synthetic */ String $baseUrl$inlined;
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0153x4a43e4c3(int i, Iterable iterable, Continuation continuation, String str, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$baseUrl$inlined = str;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0153x4a43e4c3 = new C0153x4a43e4c3(this.$concurrency, this.$this_runCatching, continuation, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0153x4a43e4c3.L$0 = obj;
        return c0153x4a43e4c3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Boolean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeFilmyfiy$lambda$1$1$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeFilmyfiy$lambda$1$1$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1}, l = {2266, 2269}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "finalUrl"}, nl = {2267, 1891}, s = {"L$0", "L$0", "L$2", "L$3"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2270\n4966#3:2269\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2270,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $baseUrl$inlined;
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, String str, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$baseUrl$inlined = str;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x0080  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Object obj;
            Throwable th;
            Exception e;
            Object objLoadExtractor;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv3 = this.$semaphore;
                    Object obj2 = this.$item;
                    this.L$0 = $this$withPermit$iv3;
                    this.L$1 = obj2;
                    this.label = 1;
                    if ($this$withPermit$iv3.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv3;
                    $this$withPermit$iv2 = null;
                    obj = obj2;
                    try {
                        Continuation $completion = (Continuation) this;
                        String finalUrl = (String) obj;
                        String str = this.$baseUrl$inlined;
                        Function1 function1 = this.$subtitleCallback$inlined;
                        Function1 function2 = this.$callback$inlined;
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = obj;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(finalUrl);
                        this.label = 2;
                        objLoadExtractor = ExtractorApiKt.loadExtractor(finalUrl, str, function1, function2, this);
                        if (objLoadExtractor == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv.release();
                        return objLoadExtractor;
                    } catch (Exception e2) {
                        e = e2;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                        objLoadExtractor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        $this$withPermit$iv.release();
                        throw th;
                    }
                    break;
                case 1:
                    $this$withPermit$iv2 = null;
                    Object obj3 = this.L$1;
                    Semaphore $this$withPermit$iv4 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$withPermit$iv = $this$withPermit$iv4;
                    obj = obj3;
                    Continuation $completion2 = (Continuation) this;
                    String finalUrl2 = (String) obj;
                    String str2 = this.$baseUrl$inlined;
                    Function1 function3 = this.$subtitleCallback$inlined;
                    Function1 function4 = this.$callback$inlined;
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(finalUrl2);
                    this.label = 2;
                    objLoadExtractor = ExtractorApiKt.loadExtractor(finalUrl2, str2, function3, function4, this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv.release();
                    return objLoadExtractor;
                case 2:
                    obj = this.L$1;
                    $this$withPermit$iv = (Semaphore) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            objLoadExtractor = $result;
                        } catch (Exception e3) {
                            e = e3;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                            objLoadExtractor = null;
                        }
                        $this$withPermit$iv.release();
                        return objLoadExtractor;
                    } catch (Throwable th3) {
                        th = th3;
                        $this$withPermit$iv.release();
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$baseUrl$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
