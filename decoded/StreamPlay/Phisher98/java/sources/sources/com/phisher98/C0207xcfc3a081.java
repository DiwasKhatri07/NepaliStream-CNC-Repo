package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
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
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeSubtitleAPI$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeSubtitleAPI$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0207xcfc3a081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0207xcfc3a081(int i, Iterable iterable, Continuation continuation, Function1 function1) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$subtitleCallback$inlined = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0207xcfc3a081 = new C0207xcfc3a081(this.$concurrency, this.$this_runCatching, continuation, this.$subtitleCallback$inlined);
        c0207xcfc3a081.L$0 = obj;
        return c0207xcfc3a081;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeSubtitleAPI$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeSubtitleAPI$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1}, l = {2266, 2272}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "it", "lan", "suburl"}, nl = {2267, 2271}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2279\n1816#3,5:2269\n1821#3,4:2275\n1#4:2274\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2279,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$subtitleCallback$inlined = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$subtitleCallback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x008e  */
        /* JADX WARN: Code duplicated, block: B:22:0x0090  */
        /* JADX WARN: Code duplicated, block: B:24:0x0093 A[Catch: all -> 0x010f, Exception -> 0x0112, TryCatch #4 {Exception -> 0x0112, all -> 0x010f, blocks: (B:19:0x006b, B:24:0x0093, B:26:0x00a5, B:28:0x00b8, B:30:0x00d4, B:27:0x00b1), top: B:49:0x006b }] */
        /* JADX WARN: Code duplicated, block: B:26:0x00a5 A[Catch: all -> 0x010f, Exception -> 0x0112, TryCatch #4 {Exception -> 0x0112, all -> 0x010f, blocks: (B:19:0x006b, B:24:0x0093, B:26:0x00a5, B:28:0x00b8, B:30:0x00d4, B:27:0x00b1), top: B:49:0x006b }] */
        /* JADX WARN: Code duplicated, block: B:27:0x00b1 A[Catch: all -> 0x010f, Exception -> 0x0112, TryCatch #4 {Exception -> 0x0112, all -> 0x010f, blocks: (B:19:0x006b, B:24:0x0093, B:26:0x00a5, B:28:0x00b8, B:30:0x00d4, B:27:0x00b1), top: B:49:0x006b }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:32:0x0101 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x0102  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            int $i$f$withPermit;
            Object obj;
            String lan;
            String suburl;
            Function1 function1;
            boolean z;
            String suburl2;
            Object objNewSubtitleFile$default;
            Function1 function2;
            char it;
            String strValueOf;
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv2 = this.$semaphore;
                    Object obj2 = this.$item;
                    this.L$0 = $this$withPermit$iv2;
                    this.L$1 = obj2;
                    this.label = 1;
                    if ($this$withPermit$iv2.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv2;
                    $i$f$withPermit = 0;
                    obj = obj2;
                    try {
                        Continuation $completion = (Continuation) this;
                        Subtitle it2 = (Subtitle) obj;
                        lan = StreamPlayUtilsKt.getLanguage(it2.getLang());
                        suburl = it2.getUrl();
                        function1 = this.$subtitleCallback$inlined;
                        if (lan.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            StringBuilder sb = new StringBuilder();
                            it = lan.charAt(0);
                            if (Character.isLowerCase(it)) {
                                strValueOf = CharsKt.titlecase(it, Locale.getDefault());
                            } else {
                                strValueOf = String.valueOf(it);
                            }
                            StringBuilder sbAppend = sb.append((Object) strValueOf);
                            String strSubstring = lan.substring(1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            suburl2 = sbAppend.append(strSubstring).toString();
                        } else {
                            suburl = suburl;
                            suburl2 = lan;
                        }
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = obj;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(it2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(lan);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(suburl);
                        this.L$6 = function1;
                        this.label = 2;
                        objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default(suburl2, suburl, (Function2) null, this, 4, (Object) null);
                        if (objNewSubtitleFile$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function2 = function1;
                        function2.invoke(objNewSubtitleFile$default);
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit;
                    } catch (Exception e) {
                        e = e;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                        unit = null;
                    } catch (Throwable th) {
                        th = th;
                        $this$withPermit$iv.release();
                        throw th;
                    }
                    break;
                case 1:
                    Object obj3 = this.L$1;
                    Semaphore $this$withPermit$iv3 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    $this$withPermit$iv = $this$withPermit$iv3;
                    obj = obj3;
                    Continuation $completion2 = (Continuation) this;
                    Subtitle it3 = (Subtitle) obj;
                    lan = StreamPlayUtilsKt.getLanguage(it3.getLang());
                    suburl = it3.getUrl();
                    function1 = this.$subtitleCallback$inlined;
                    if (lan.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        StringBuilder sb2 = new StringBuilder();
                        it = lan.charAt(0);
                        if (Character.isLowerCase(it)) {
                            strValueOf = CharsKt.titlecase(it, Locale.getDefault());
                        } else {
                            strValueOf = String.valueOf(it);
                        }
                        StringBuilder sbAppend2 = sb2.append((Object) strValueOf);
                        String strSubstring2 = lan.substring(1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        suburl2 = sbAppend2.append(strSubstring2).toString();
                    } else {
                        suburl = suburl;
                        suburl2 = lan;
                    }
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(it3);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(lan);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(suburl);
                    this.L$6 = function1;
                    this.label = 2;
                    objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default(suburl2, suburl, (Function2) null, this, 4, (Object) null);
                    if (objNewSubtitleFile$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function2 = function1;
                    function2.invoke(objNewSubtitleFile$default);
                    unit = Unit.INSTANCE;
                    $this$withPermit$iv.release();
                    return unit;
                case 2:
                    function2 = (Function1) this.L$6;
                    obj = this.L$1;
                    $this$withPermit$iv = (Semaphore) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            objNewSubtitleFile$default = $result;
                            function2.invoke(objNewSubtitleFile$default);
                            unit = Unit.INSTANCE;
                            break;
                        } catch (Exception e2) {
                            e = e2;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                            unit = null;
                        }
                        $this$withPermit$iv.release();
                        return unit;
                    } catch (Throwable th2) {
                        th = th2;
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
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$subtitleCallback$inlined), 2, (Object) null));
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
