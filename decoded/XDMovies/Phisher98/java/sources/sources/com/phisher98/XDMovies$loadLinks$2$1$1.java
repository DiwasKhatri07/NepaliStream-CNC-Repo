package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: XDMovies.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.XDMovies$loadLinks$2$1$1", f = "XDMovies.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {513, 520, 522}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$this$launch", "loaded", "$this$launch", "$this$invokeSuspend_u24lambda_u242", "loaded"}, nl = {514, 521, 523}, s = {"L$0", "L$1", "L$0", "Z$0", "L$0", "L$2", "Z$0"}, v = 2)
final class XDMovies$loadLinks$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $link;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    final /* synthetic */ AtomicInteger $successCount;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ XDMovies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XDMovies$loadLinks$2$1$1(AtomicInteger atomicInteger, String str, XDMovies xDMovies, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super XDMovies$loadLinks$2$1$1> continuation) {
        super(2, continuation);
        this.$successCount = atomicInteger;
        this.$link = str;
        this.this$0 = xDMovies;
        this.$subtitleCallback = function1;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> xDMovies$loadLinks$2$1$1 = new XDMovies$loadLinks$2$1$1(this.$successCount, this.$link, this.this$0, this.$subtitleCallback, this.$callback, continuation);
        xDMovies$loadLinks$2$1$1.L$0 = obj;
        return xDMovies$loadLinks$2$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007f  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00f6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:43:0x0119  */
    /* JADX WARN: Code duplicated, block: B:45:0x0146  */
    public final Object invokeSuspend(Object $result) {
        Object objBoxBoolean;
        Object obj;
        String str;
        boolean loaded;
        String str2;
        Function1<SubtitleFile, Unit> function1;
        Function1<ExtractorLink, Unit> function2;
        AtomicInteger atomicInteger;
        String name;
        AtomicInteger atomicInteger2;
        String str3;
        Throwable it;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String str4 = this.$link;
                        XDMovies xDMovies = this.this$0;
                        Function1<SubtitleFile, Unit> function3 = this.$subtitleCallback;
                        Function1<ExtractorLink, Unit> function4 = this.$callback;
                        Result.Companion companion = Result.Companion;
                        String name2 = xDMovies.getName();
                        this.L$0 = $this$launch;
                        this.L$1 = SpillingKt.nullOutSpilledVariable($this$launch);
                        this.label = 1;
                        if (ExtractorApiKt.loadExtractor(str4, name2, function3, function4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objBoxBoolean = Result.constructor-impl(Boxing.boxBoolean(true));
                        str = this.$link;
                        if (Result.exceptionOrNull-impl(objBoxBoolean) != null) {
                            Log.INSTANCE.w("XDMovies", "First attempt failed for " + str + " — retrying in 1.5s");
                            objBoxBoolean = Boxing.boxBoolean(false);
                        }
                        loaded = ((Boolean) objBoxBoolean).booleanValue();
                        if (loaded) {
                            Boxing.boxInt(this.$successCount.incrementAndGet());
                        } else {
                            Duration.Companion companion2 = Duration.Companion;
                            this.L$0 = $this$launch;
                            this.L$1 = null;
                            this.Z$0 = loaded;
                            this.label = 2;
                            if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(1500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str2 = this.$link;
                            XDMovies xDMovies2 = this.this$0;
                            function1 = this.$subtitleCallback;
                            function2 = this.$callback;
                            atomicInteger = this.$successCount;
                            Result.Companion companion3 = Result.Companion;
                            name = xDMovies2.getName();
                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                            this.L$1 = atomicInteger;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($this$launch);
                            this.Z$0 = loaded;
                            this.label = 3;
                            if (ExtractorApiKt.loadExtractor(str2, name, function1, function2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            atomicInteger2 = atomicInteger;
                            obj = Result.constructor-impl(Boxing.boxInt(atomicInteger2.incrementAndGet()));
                            str3 = this.$link;
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                                Log.INSTANCE.e("XDMovies", "Retry also failed for " + str3 + ": " + it.getMessage());
                            }
                            Result.box-impl(obj);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        objBoxBoolean = Result.constructor-impl(Boxing.boxBoolean(true));
                        str = this.$link;
                        if (Result.exceptionOrNull-impl(objBoxBoolean) != null) {
                            Log.INSTANCE.w("XDMovies", "First attempt failed for " + str + " — retrying in 1.5s");
                            objBoxBoolean = Boxing.boxBoolean(false);
                        }
                        loaded = ((Boolean) objBoxBoolean).booleanValue();
                        if (loaded) {
                            Duration.Companion companion4 = Duration.Companion;
                            this.L$0 = $this$launch;
                            this.L$1 = null;
                            this.Z$0 = loaded;
                            this.label = 2;
                            if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(1500, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str2 = this.$link;
                            XDMovies xDMovies3 = this.this$0;
                            function1 = this.$subtitleCallback;
                            function2 = this.$callback;
                            atomicInteger = this.$successCount;
                            Result.Companion companion5 = Result.Companion;
                            name = xDMovies3.getName();
                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                            this.L$1 = atomicInteger;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($this$launch);
                            this.Z$0 = loaded;
                            this.label = 3;
                            if (ExtractorApiKt.loadExtractor(str2, name, function1, function2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            atomicInteger2 = atomicInteger;
                            obj = Result.constructor-impl(Boxing.boxInt(atomicInteger2.incrementAndGet()));
                            str3 = this.$link;
                            it = Result.exceptionOrNull-impl(obj);
                            if (it != null) {
                                Log.INSTANCE.e("XDMovies", "Retry also failed for " + str3 + ": " + it.getMessage());
                            }
                            Result.box-impl(obj);
                        } else {
                            Boxing.boxInt(this.$successCount.incrementAndGet());
                        }
                        return Unit.INSTANCE;
                    case 2:
                        loaded = this.Z$0;
                        ResultKt.throwOnFailure($result);
                        str2 = this.$link;
                        XDMovies xDMovies4 = this.this$0;
                        function1 = this.$subtitleCallback;
                        function2 = this.$callback;
                        atomicInteger = this.$successCount;
                        Result.Companion companion6 = Result.Companion;
                        name = xDMovies4.getName();
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                        this.L$1 = atomicInteger;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($this$launch);
                        this.Z$0 = loaded;
                        this.label = 3;
                        if (ExtractorApiKt.loadExtractor(str2, name, function1, function2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        atomicInteger2 = atomicInteger;
                        obj = Result.constructor-impl(Boxing.boxInt(atomicInteger2.incrementAndGet()));
                        str3 = this.$link;
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                            Log.INSTANCE.e("XDMovies", "Retry also failed for " + str3 + ": " + it.getMessage());
                        }
                        Result.box-impl(obj);
                        return Unit.INSTANCE;
                    case 3:
                        boolean z = this.Z$0;
                        atomicInteger2 = (AtomicInteger) this.L$1;
                        ResultKt.throwOnFailure($result);
                        obj = Result.constructor-impl(Boxing.boxInt(atomicInteger2.incrementAndGet()));
                        str3 = this.$link;
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                            Log.INSTANCE.e("XDMovies", "Retry also failed for " + str3 + ": " + it.getMessage());
                        }
                        Result.box-impl(obj);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th) {
                Result.Companion companion7 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            Result.Companion companion8 = Result.Companion;
            objBoxBoolean = Result.constructor-impl(ResultKt.createFailure(th2));
        }
    }
}
