package com.phisher98;

import android.app.ActivityManager;
import android.content.Context;
import com.lagradost.api.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayConcurrency.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJX\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2>\u0010\u000f\u001a \u0012\u001c\b\u0001\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00110\u0010\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/phisher98/StreamPlayConcurrency;", "", "<init>", "()V", "TAG", "", "detectedProfile", "Lcom/phisher98/StreamPlayConcurrency$DeviceProfile;", "detectDeviceProfile", "context", "Landroid/content/Context;", "runLimitedAsync", "", "concurrency", "", "tasks", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(I[Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdaptiveTimeout", "", "providerId", "baseTimeoutMs", "DeviceProfile", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class StreamPlayConcurrency {

    @NotNull
    public static final StreamPlayConcurrency INSTANCE = new StreamPlayConcurrency();

    @NotNull
    private static final String TAG = "StreamPlayConcurrency";

    @Nullable
    private static DeviceProfile detectedProfile;

    private StreamPlayConcurrency() {
    }

    /* JADX INFO: compiled from: StreamPlayConcurrency.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000b"}, d2 = {"Lcom/phisher98/StreamPlayConcurrency$DeviceProfile;", "", "<init>", "(Ljava/lang/String;I)V", "LOW_END", "MID_RANGE", "HIGH_END", "recommendedConcurrency", "", "getRecommendedConcurrency", "()I", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public enum DeviceProfile {
        LOW_END,
        MID_RANGE,
        HIGH_END;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        /* JADX INFO: compiled from: StreamPlayConcurrency.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DeviceProfile.values().length];
                try {
                    iArr[DeviceProfile.LOW_END.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[DeviceProfile.MID_RANGE.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[DeviceProfile.HIGH_END.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @NotNull
        public static EnumEntries<DeviceProfile> getEntries() {
            return $ENTRIES;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final int getRecommendedConcurrency() throws NoWhenBranchMatchedException {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return 8;
                case 2:
                    return 20;
                case 3:
                    return 40;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    @NotNull
    public final DeviceProfile detectDeviceProfile(@NotNull Context context) {
        DeviceProfile profile;
        if (detectedProfile != null) {
            DeviceProfile deviceProfile = detectedProfile;
            Intrinsics.checkNotNull(deviceProfile);
            return deviceProfile;
        }
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        long totalRamMB = memoryInfo.totalMem / 1048576;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (totalRamMB < 2048 || availableProcessors < 4) {
            profile = DeviceProfile.LOW_END;
        } else if (totalRamMB < 4096 || availableProcessors < 6) {
            profile = DeviceProfile.MID_RANGE;
        } else {
            profile = DeviceProfile.HIGH_END;
        }
        detectedProfile = profile;
        Log.INSTANCE.d(TAG, "🔍 Detected device: " + profile + " (RAM: " + totalRamMB + "MB, Cores: " + availableProcessors + ')');
        return profile;
    }

    public static /* synthetic */ Object runLimitedAsync$default(StreamPlayConcurrency streamPlayConcurrency, int i, Function1[] function1Arr, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 5;
        }
        return streamPlayConcurrency.runLimitedAsync(i, function1Arr, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayConcurrency$runLimitedAsync$2 */
    /* JADX INFO: compiled from: StreamPlayConcurrency.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayConcurrency$runLimitedAsync$2", f = "StreamPlayConcurrency.kt", i = {0, 0}, l = {91}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {92}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayConcurrency.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayConcurrency.kt\ncom/phisher98/StreamPlayConcurrency$runLimitedAsync$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,113:1\n12746#2:114\n13093#2,3:115\n*S KotlinDebug\n*F\n+ 1 StreamPlayConcurrency.kt\ncom/phisher98/StreamPlayConcurrency$runLimitedAsync$2\n*L\n81#1:114\n81#1:115,3\n*E\n"})
    static final class C01012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $concurrency;
        final /* synthetic */ Function1<Continuation<? super Unit>, Object>[] $tasks;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01012(Function1<? super Continuation<? super Unit>, ? extends Object>[] function1Arr, int i, Continuation<? super C01012> continuation) {
            super(2, continuation);
            this.$tasks = function1Arr;
            this.$concurrency = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01012 = new C01012(this.$tasks, this.$concurrency, continuation);
            c01012.L$0 = obj;
            return c01012;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    int i = 0;
                    if (this.$tasks.length == 0) {
                        return Unit.INSTANCE;
                    }
                    Semaphore semaphore = SemaphoreKt.Semaphore$default(this.$concurrency, 0, 2, (Object) null);
                    Function1<Continuation<? super Unit>, Object>[] function1Arr = this.$tasks;
                    Collection destination$iv$iv = new ArrayList(function1Arr.length);
                    for (int length = function1Arr.length; i < length; length = length) {
                        destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new StreamPlayConcurrency$runLimitedAsync$2$1$1(semaphore, function1Arr[i], null), 2, (Object) null));
                        i++;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(semaphore);
                    this.label = 1;
                    if (AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object runLimitedAsync(int concurrency, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object>[] function1Arr, @NotNull Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C01012(function1Arr, concurrency, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ long getAdaptiveTimeout$default(StreamPlayConcurrency streamPlayConcurrency, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 15000;
        }
        return streamPlayConcurrency.getAdaptiveTimeout(str, j);
    }

    public final long getAdaptiveTimeout(@NotNull String providerId, long baseTimeoutMs) {
        StreamPlayCache.ProviderStats stats = StreamPlayCache.INSTANCE.getProviderStats(providerId);
        if (stats.getSuccessCount() == 0) {
            return baseTimeoutMs;
        }
        if (stats.isCircuitBroken()) {
            return 5000L;
        }
        long avgTime = stats.getAvgTimeMs();
        if (avgTime == 0) {
            return baseTimeoutMs;
        }
        if (avgTime < 3000) {
            return Math.max(2000 + avgTime, 5000L);
        }
        return avgTime < 10000 ? 5000 + avgTime : Math.min(5000 + avgTime, 2 * baseTimeoutMs);
    }
}
