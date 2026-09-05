package com.phisher98;

import com.lagradost.api.Log;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeTopMovies$lambda$3$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeTopMovies$lambda$3$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0214x5ff82339 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ String $topmoviesAPI$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0214x5ff82339(int i, Iterable iterable, Continuation continuation, String str, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$topmoviesAPI$inlined = str;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0214x5ff82339 = new C0214x5ff82339(this.$concurrency, this.$this_runCatching, continuation, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0214x5ff82339.L$0 = obj;
        return c0214x5ff82339;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeTopMovies$lambda$3$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeTopMovies$lambda$3$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {2266, 2270, 2275}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "driveLink", "$this$withPermit$iv", "$completion", "driveLink", "finalLink"}, nl = {2267, 2272, 2282}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2283\n2306#3,14:2269\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2283,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        final /* synthetic */ String $topmoviesAPI$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, String str, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$topmoviesAPI$inlined = str;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0093 A[Catch: all -> 0x0049, Exception -> 0x004c, TryCatch #1 {Exception -> 0x004c, blocks: (B:7:0x0029, B:10:0x0043, B:27:0x00ac, B:29:0x00b0, B:22:0x007c, B:24:0x0093), top: B:55:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x00ab A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x00b0 A[Catch: all -> 0x0049, Exception -> 0x004c, TRY_LEAVE, TryCatch #1 {Exception -> 0x004c, blocks: (B:7:0x0029, B:10:0x0043, B:27:0x00ac, B:29:0x00b0, B:22:0x007c, B:24:0x0093), top: B:55:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:32:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:38:0x0113 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x0114  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Object obj;
            Object obj2;
            int $i$f$withPermit;
            int i;
            String driveLink;
            Continuation $completion;
            int i2;
            int $i$f$withPermit2;
            String finalLink;
            String driveLink2;
            int i3;
            int i4;
            Continuation $completion2;
            Object obj3;
            Semaphore $this$withPermit$iv3;
            Object objBypassHrefli;
            Semaphore $this$withPermit$iv4;
            Object obj4;
            Object objLoadSourceNameExtractor$default;
            Object obj5;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object obj6 = null;
            try {
                try {
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
                            $this$withPermit$iv2 = $this$withPermit$iv5;
                            obj2 = obj7;
                            $i$f$withPermit = 0;
                            i = 0;
                            driveLink = (String) obj2;
                            $completion = (Continuation) this;
                            i2 = 0;
                            try {
                                try {
                                    if (StringsKt.contains$default(driveLink, "unblockedgames", false, 2, (Object) null)) {
                                        this.L$0 = $this$withPermit$iv2;
                                        this.L$1 = obj2;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(driveLink);
                                        this.label = 2;
                                        objBypassHrefli = StreamPlayUtilsKt.bypassHrefli(driveLink, this);
                                        if (objBypassHrefli == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        str = (String) objBypassHrefli;
                                        if (str == null) {
                                            obj6 = Unit.INSTANCE;
                                        } else {
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            driveLink2 = driveLink;
                                            finalLink = str;
                                            i3 = i2;
                                            i4 = i;
                                            $completion2 = $completion;
                                            obj3 = obj2;
                                            $this$withPermit$iv3 = $this$withPermit$iv2;
                                        }
                                        $this$withPermit$iv2.release();
                                        return obj6;
                                    }
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    finalLink = driveLink;
                                    driveLink2 = finalLink;
                                    i3 = 0;
                                    i4 = 0;
                                    $completion2 = $completion;
                                    obj3 = obj2;
                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                    objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("TopMovies", finalLink, str, function1, function1, null, null, this, 96, null);
                                    if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$withPermit$iv2 = $this$withPermit$iv4;
                                    obj5 = objLoadSourceNameExtractor$default;
                                    obj6 = obj5;
                                    $this$withPermit$iv2.release();
                                    return obj6;
                                } catch (Exception e) {
                                    e = e;
                                    $this$withPermit$iv2 = $this$withPermit$iv4;
                                    obj = obj4;
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                } catch (Throwable th) {
                                    th = th;
                                    $this$withPermit$iv = $this$withPermit$iv4;
                                    $this$withPermit$iv.release();
                                    throw th;
                                }
                                String str2 = this.$topmoviesAPI$inlined + '/';
                                Function1 function1 = this.$subtitleCallback$inlined;
                                Function1 function2 = this.$callback$inlined;
                                this.L$0 = $this$withPermit$iv3;
                                this.L$1 = obj3;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(driveLink2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(finalLink);
                                this.label = 3;
                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                obj4 = obj3;
                            } catch (Exception e2) {
                                e = e2;
                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                obj = obj3;
                            } catch (Throwable th2) {
                                th = th2;
                                $this$withPermit$iv = $this$withPermit$iv3;
                            }
                            break;
                        case 1:
                            Object obj8 = this.L$1;
                            Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            obj2 = obj8;
                            $this$withPermit$iv2 = $this$withPermit$iv6;
                            $i$f$withPermit = 0;
                            i = 0;
                            driveLink = (String) obj2;
                            $completion = (Continuation) this;
                            i2 = 0;
                            if (StringsKt.contains$default(driveLink, "unblockedgames", false, 2, (Object) null)) {
                                this.L$0 = $this$withPermit$iv2;
                                this.L$1 = obj2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(driveLink);
                                this.label = 2;
                                objBypassHrefli = StreamPlayUtilsKt.bypassHrefli(driveLink, this);
                                if (objBypassHrefli == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str = (String) objBypassHrefli;
                                if (str == null) {
                                    obj6 = Unit.INSTANCE;
                                } else {
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    driveLink2 = driveLink;
                                    finalLink = str;
                                    i3 = i2;
                                    i4 = i;
                                    $completion2 = $completion;
                                    obj3 = obj2;
                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                }
                                $this$withPermit$iv2.release();
                                return obj6;
                            }
                            $i$f$withPermit2 = $i$f$withPermit;
                            finalLink = driveLink;
                            driveLink2 = finalLink;
                            i3 = 0;
                            i4 = 0;
                            $completion2 = $completion;
                            obj3 = obj2;
                            $this$withPermit$iv3 = $this$withPermit$iv2;
                            String str3 = this.$topmoviesAPI$inlined + '/';
                            Function1 function3 = this.$subtitleCallback$inlined;
                            Function1 function4 = this.$callback$inlined;
                            this.L$0 = $this$withPermit$iv3;
                            this.L$1 = obj3;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(driveLink2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(finalLink);
                            this.label = 3;
                            $this$withPermit$iv4 = $this$withPermit$iv3;
                            obj4 = obj3;
                            objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("TopMovies", finalLink, str3, function3, function4, null, null, this, 96, null);
                            if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$withPermit$iv2 = $this$withPermit$iv4;
                            obj5 = objLoadSourceNameExtractor$default;
                            obj6 = obj5;
                            $this$withPermit$iv2.release();
                            return obj6;
                        case 2:
                            $i$f$withPermit = 0;
                            i = 0;
                            i2 = 0;
                            driveLink = (String) this.L$3;
                            $completion = (Continuation) this.L$2;
                            obj2 = this.L$1;
                            $this$withPermit$iv2 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            objBypassHrefli = $result;
                            str = (String) objBypassHrefli;
                            if (str == null) {
                                obj6 = Unit.INSTANCE;
                            } else {
                                $i$f$withPermit2 = $i$f$withPermit;
                                driveLink2 = driveLink;
                                finalLink = str;
                                i3 = i2;
                                i4 = i;
                                $completion2 = $completion;
                                obj3 = obj2;
                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                String str4 = this.$topmoviesAPI$inlined + '/';
                                Function1 function5 = this.$subtitleCallback$inlined;
                                Function1 function6 = this.$callback$inlined;
                                this.L$0 = $this$withPermit$iv3;
                                this.L$1 = obj3;
                                this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(driveLink2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(finalLink);
                                this.label = 3;
                                $this$withPermit$iv4 = $this$withPermit$iv3;
                                obj4 = obj3;
                                objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("TopMovies", finalLink, str4, function5, function6, null, null, this, 96, null);
                                if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$withPermit$iv2 = $this$withPermit$iv4;
                                obj5 = objLoadSourceNameExtractor$default;
                                obj6 = obj5;
                            }
                            $this$withPermit$iv2.release();
                            return obj6;
                        case 3:
                            Object obj9 = this.L$1;
                            $this$withPermit$iv2 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit2 = 0;
                            obj5 = $result;
                            obj6 = obj5;
                            $this$withPermit$iv2.release();
                            return obj6;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                th = th3;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
