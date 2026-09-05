package com.phisher98;

import android.content.SharedPreferences;
import com.lagradost.api.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayCache.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u00042345B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u0005J\u0016\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0017J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0005J\u001e\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020\u0005J\u0010\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u0005J\u0016\u0010,\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005J\u0010\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u00101\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u000100R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/phisher98/StreamPlayCache;", "", "<init>", "()V", "TAG", "", "apiCacheEntry", "Lcom/phisher98/StreamPlayCache$ApiCacheEntry;", "apiCacheMutex", "Lkotlinx/coroutines/sync/Mutex;", "API_CACHE_TTL_MS", "", "API_CACHE_SHORT_TTL_MS", "getCachedApiBase", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheApiBase", "", "url", "success", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animeIdCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/phisher98/StreamPlayCache$AnimeIdMapping;", "ANIME_ID_CACHE_TTL_MS", "ANIME_ID_CACHE_MAX_SIZE", "", "getCachedAnimeIds", "key", "cacheAnimeIds", "mapping", "providerStatsMap", "Lcom/phisher98/StreamPlayCache$ProviderStats;", "getProviderStats", "providerId", "recordProviderExecution", "durationMs", "getProviderPriorityScore", "", "metadataCache", "Lcom/phisher98/StreamPlayCache$MetadataCache;", "METADATA_CACHE_TTL_MS", "METADATA_CACHE_MAX_SIZE", "getCachedMetadata", "cacheMetadata", "data", "saveProviderStats", "prefs", "Landroid/content/SharedPreferences;", "loadProviderStats", "ApiCacheEntry", "AnimeIdMapping", "ProviderStats", "MetadataCache", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayCache.kt\ncom/phisher98/StreamPlayCache\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,284:1\n117#2,10:285\n117#2,10:295\n2622#3,14:305\n2622#3,14:319\n221#4,2:333\n221#4,2:335\n*S KotlinDebug\n*F\n+ 1 StreamPlayCache.kt\ncom/phisher98/StreamPlayCache\n*L\n36#1:285,10\n54#1:295,10\n116#1:305,14\n235#1:319,14\n250#1:333,2\n262#1:335,2\n*E\n"})
public final class StreamPlayCache {
    private static final int ANIME_ID_CACHE_MAX_SIZE = 500;
    private static final long ANIME_ID_CACHE_TTL_MS = 86400000;
    private static final long API_CACHE_SHORT_TTL_MS = 120000;
    private static final long API_CACHE_TTL_MS = 600000;
    private static final int METADATA_CACHE_MAX_SIZE = 100;
    private static final long METADATA_CACHE_TTL_MS = 1800000;

    @NotNull
    private static final String TAG = "StreamPlayCache";

    @Nullable
    private static ApiCacheEntry apiCacheEntry;

    @NotNull
    public static final StreamPlayCache INSTANCE = new StreamPlayCache();

    @NotNull
    private static final Mutex apiCacheMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private static final ConcurrentHashMap<String, AnimeIdMapping> animeIdCache = new ConcurrentHashMap<>();

    @NotNull
    private static final ConcurrentHashMap<String, ProviderStats> providerStatsMap = new ConcurrentHashMap<>();

    @NotNull
    private static final ConcurrentHashMap<String, MetadataCache> metadataCache = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.phisher98.StreamPlayCache$cacheApiBase$1 */
    /* JADX INFO: compiled from: StreamPlayCache.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayCache", f = "StreamPlayCache.kt", i = {0, 0, 0}, l = {289}, m = "cacheApiBase", n = {"url", "$this$withLock_u24default$iv", "success"}, nl = {290}, s = {"L$0", "L$1", "Z$0"}, v = 2)
    static final class C00991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00991(Continuation<? super C00991> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayCache.this.cacheApiBase(null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayCache$getCachedApiBase$1 */
    /* JADX INFO: compiled from: StreamPlayCache.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayCache", f = "StreamPlayCache.kt", i = {0}, l = {289}, m = "getCachedApiBase", n = {"$this$withLock_u24default$iv"}, nl = {290}, s = {"L$0"}, v = 2)
    static final class C01001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01001(Continuation<? super C01001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayCache.this.getCachedApiBase((Continuation) this);
        }
    }

    private StreamPlayCache() {
    }

    /* JADX INFO: compiled from: StreamPlayCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/phisher98/StreamPlayCache$ApiCacheEntry;", "", "url", "", "timestamp", "", "successCount", "", "failureCount", "<init>", "(Ljava/lang/String;JII)V", "getUrl", "()Ljava/lang/String;", "getTimestamp", "()J", "getSuccessCount", "()I", "getFailureCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ApiCacheEntry {
        private final int failureCount;
        private final int successCount;
        private final long timestamp;

        @NotNull
        private final String url;

        public static /* synthetic */ ApiCacheEntry copy$default(ApiCacheEntry apiCacheEntry, String str, long j, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = apiCacheEntry.url;
            }
            if ((i3 & 2) != 0) {
                j = apiCacheEntry.timestamp;
            }
            if ((i3 & 4) != 0) {
                i = apiCacheEntry.successCount;
            }
            if ((i3 & 8) != 0) {
                i2 = apiCacheEntry.failureCount;
            }
            return apiCacheEntry.copy(str, j, i, i2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getSuccessCount() {
            return this.successCount;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getFailureCount() {
            return this.failureCount;
        }

        @NotNull
        public final ApiCacheEntry copy(@NotNull String url, long timestamp, int successCount, int failureCount) {
            return new ApiCacheEntry(url, timestamp, successCount, failureCount);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiCacheEntry)) {
                return false;
            }
            ApiCacheEntry apiCacheEntry = (ApiCacheEntry) other;
            return Intrinsics.areEqual(this.url, apiCacheEntry.url) && this.timestamp == apiCacheEntry.timestamp && this.successCount == apiCacheEntry.successCount && this.failureCount == apiCacheEntry.failureCount;
        }

        public int hashCode() {
            return (((((this.url.hashCode() * 31) + StreamPlayCache$ApiCacheEntry$$ExternalSyntheticBackport0.m24m(this.timestamp)) * 31) + this.successCount) * 31) + this.failureCount;
        }

        @NotNull
        public String toString() {
            return "ApiCacheEntry(url=" + this.url + ", timestamp=" + this.timestamp + ", successCount=" + this.successCount + ", failureCount=" + this.failureCount + ')';
        }

        public ApiCacheEntry(@NotNull String url, long timestamp, int successCount, int failureCount) {
            this.url = url;
            this.timestamp = timestamp;
            this.successCount = successCount;
            this.failureCount = failureCount;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ApiCacheEntry(String str, long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            int i4;
            i = (i3 & 4) != 0 ? 0 : i;
            if ((i3 & 8) == 0) {
                i4 = i2;
            } else {
                i4 = 0;
            }
            this(str, j, i, i4);
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final int getSuccessCount() {
            return this.successCount;
        }

        public final int getFailureCount() {
            return this.failureCount;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object getCachedApiBase(@NotNull Continuation<? super String> continuation) {
        C01001 c01001;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        String url;
        if (continuation instanceof C01001) {
            c01001 = (C01001) continuation;
            if ((c01001.label & Integer.MIN_VALUE) != 0) {
                c01001.label -= Integer.MIN_VALUE;
            } else {
                c01001 = new C01001(continuation);
            }
        } else {
            c01001 = new C01001(continuation);
        }
        C01001 c01002 = c01001;
        Object $result = c01002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c01002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$withLock_u24default$iv = apiCacheMutex;
                owner$iv = null;
                c01002.L$0 = $this$withLock_u24default$iv;
                c01002.label = 1;
                if ($this$withLock_u24default$iv.lock((Object) null, c01002) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) c01002.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            ApiCacheEntry entry = apiCacheEntry;
            if (entry != null) {
                long age = System.currentTimeMillis() - entry.getTimestamp();
                long ttl = entry.getFailureCount() > 0 ? API_CACHE_SHORT_TTL_MS : API_CACHE_TTL_MS;
                try {
                    if (age < ttl) {
                        Log.INSTANCE.d(TAG, "✅ Using cached API base: " + entry.getUrl() + " (age: " + (age / 1000) + "s)");
                        url = entry.getUrl();
                    } else {
                        Log.INSTANCE.d(TAG, "⏰ API cache expired (age: " + (age / 1000) + "s, TTL: " + (ttl / 1000) + "s)");
                        url = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    throw th;
                }
            } else {
                url = null;
            }
            $this$withLock_u24default$iv.unlock(owner$iv);
            return url;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ Object cacheApiBase$default(StreamPlayCache streamPlayCache, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return streamPlayCache.cacheApiBase(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object cacheApiBase(@NotNull String url, boolean success, @NotNull Continuation<? super Unit> continuation) {
        C00991 c00991;
        String url2;
        Mutex $this$withLock_u24default$iv;
        Mutex $this$withLock_u24default$iv2;
        boolean success2;
        ApiCacheEntry apiCacheEntry2;
        if (continuation instanceof C00991) {
            c00991 = (C00991) continuation;
            if ((c00991.label & Integer.MIN_VALUE) != 0) {
                c00991.label -= Integer.MIN_VALUE;
            } else {
                c00991 = new C00991(continuation);
            }
        } else {
            c00991 = new C00991(continuation);
        }
        C00991 c00992 = c00991;
        Object $result = c00992.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00992.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Mutex $this$withLock_u24default$iv3 = apiCacheMutex;
                c00992.L$0 = url;
                c00992.L$1 = $this$withLock_u24default$iv3;
                c00992.Z$0 = success;
                c00992.label = 1;
                if ($this$withLock_u24default$iv3.lock((Object) null, c00992) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                $this$withLock_u24default$iv2 = null;
                success2 = success;
                break;
                break;
            case 1:
                success2 = c00992.Z$0;
                Mutex $this$withLock_u24default$iv4 = (Mutex) c00992.L$1;
                String url3 = (String) c00992.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url3;
                $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                $this$withLock_u24default$iv2 = null;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            ApiCacheEntry current = apiCacheEntry;
            if (success2) {
                apiCacheEntry2 = new ApiCacheEntry(url2, System.currentTimeMillis(), (current != null ? current.getSuccessCount() : 0) + 1, 0);
            } else {
                apiCacheEntry2 = new ApiCacheEntry(url2, System.currentTimeMillis(), current != null ? current.getSuccessCount() : 0, (current != null ? current.getFailureCount() : 0) + 1);
            }
            apiCacheEntry = apiCacheEntry2;
            Log.INSTANCE.d(TAG, "📦 Cached API base: " + url2 + " (success: " + (success2) + ')');
            return Unit.INSTANCE;
        } finally {
            $this$withLock_u24default$iv.unlock($this$withLock_u24default$iv2);
        }
    }

    /* JADX INFO: compiled from: StreamPlayCache.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/phisher98/StreamPlayCache$AnimeIdMapping;", "", "anilistId", "", "malId", "kitsuId", "zoroId", "animekaiId", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAnilistId", "()Ljava/lang/String;", "getMalId", "getKitsuId", "getZoroId", "getAnimekaiId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnimeIdMapping {

        @Nullable
        private final String anilistId;

        @Nullable
        private final String animekaiId;

        @Nullable
        private final String kitsuId;

        @Nullable
        private final String malId;
        private final long timestamp;

        @Nullable
        private final String zoroId;

        public AnimeIdMapping() {
            this(null, null, null, null, null, 0L, 63, null);
        }

        public static /* synthetic */ AnimeIdMapping copy$default(AnimeIdMapping animeIdMapping, String str, String str2, String str3, String str4, String str5, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = animeIdMapping.anilistId;
            }
            if ((i & 2) != 0) {
                str2 = animeIdMapping.malId;
            }
            if ((i & 4) != 0) {
                str3 = animeIdMapping.kitsuId;
            }
            if ((i & 8) != 0) {
                str4 = animeIdMapping.zoroId;
            }
            if ((i & 16) != 0) {
                str5 = animeIdMapping.animekaiId;
            }
            if ((i & 32) != 0) {
                j = animeIdMapping.timestamp;
            }
            long j2 = j;
            String str6 = str5;
            String str7 = str3;
            return animeIdMapping.copy(str, str2, str7, str4, str6, j2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMalId() {
            return this.malId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKitsuId() {
            return this.kitsuId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getZoroId() {
            return this.zoroId;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAnimekaiId() {
            return this.animekaiId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        @NotNull
        public final AnimeIdMapping copy(@Nullable String anilistId, @Nullable String malId, @Nullable String kitsuId, @Nullable String zoroId, @Nullable String animekaiId, long timestamp) {
            return new AnimeIdMapping(anilistId, malId, kitsuId, zoroId, animekaiId, timestamp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimeIdMapping)) {
                return false;
            }
            AnimeIdMapping animeIdMapping = (AnimeIdMapping) other;
            return Intrinsics.areEqual(this.anilistId, animeIdMapping.anilistId) && Intrinsics.areEqual(this.malId, animeIdMapping.malId) && Intrinsics.areEqual(this.kitsuId, animeIdMapping.kitsuId) && Intrinsics.areEqual(this.zoroId, animeIdMapping.zoroId) && Intrinsics.areEqual(this.animekaiId, animeIdMapping.animekaiId) && this.timestamp == animeIdMapping.timestamp;
        }

        public int hashCode() {
            return ((((((((((this.anilistId == null ? 0 : this.anilistId.hashCode()) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.kitsuId == null ? 0 : this.kitsuId.hashCode())) * 31) + (this.zoroId == null ? 0 : this.zoroId.hashCode())) * 31) + (this.animekaiId != null ? this.animekaiId.hashCode() : 0)) * 31) + StreamPlayCache$AnimeIdMapping$$ExternalSyntheticBackport0.m23m(this.timestamp);
        }

        @NotNull
        public String toString() {
            return "AnimeIdMapping(anilistId=" + this.anilistId + ", malId=" + this.malId + ", kitsuId=" + this.kitsuId + ", zoroId=" + this.zoroId + ", animekaiId=" + this.animekaiId + ", timestamp=" + this.timestamp + ')';
        }

        public AnimeIdMapping(@Nullable String anilistId, @Nullable String malId, @Nullable String kitsuId, @Nullable String zoroId, @Nullable String animekaiId, long timestamp) {
            this.anilistId = anilistId;
            this.malId = malId;
            this.kitsuId = kitsuId;
            this.zoroId = zoroId;
            this.animekaiId = animekaiId;
            this.timestamp = timestamp;
        }

        public /* synthetic */ AnimeIdMapping(String str, String str2, String str3, String str4, String str5, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? System.currentTimeMillis() : j);
        }

        @Nullable
        public final String getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        public final String getMalId() {
            return this.malId;
        }

        @Nullable
        public final String getKitsuId() {
            return this.kitsuId;
        }

        @Nullable
        public final String getZoroId() {
            return this.zoroId;
        }

        @Nullable
        public final String getAnimekaiId() {
            return this.animekaiId;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    @Nullable
    public final AnimeIdMapping getCachedAnimeIds(@NotNull String key) {
        AnimeIdMapping mapping = animeIdCache.get(key);
        if (mapping == null) {
            return null;
        }
        long age = System.currentTimeMillis() - mapping.getTimestamp();
        if (age < ANIME_ID_CACHE_TTL_MS) {
            Log.INSTANCE.d(TAG, "✅ Anime ID cache hit: " + key);
            return mapping;
        }
        Log.INSTANCE.d(TAG, "⏰ Anime ID cache expired: " + key);
        animeIdCache.remove(key);
        return null;
    }

    public final void cacheAnimeIds(@NotNull String key, @NotNull AnimeIdMapping mapping) {
        Object minElem$iv;
        if (animeIdCache.size() >= ANIME_ID_CACHE_MAX_SIZE) {
            Iterable $this$minByOrNull$iv = animeIdCache.entrySet();
            Iterator iterator$iv = $this$minByOrNull$iv.iterator();
            if (iterator$iv.hasNext()) {
                minElem$iv = iterator$iv.next();
                if (iterator$iv.hasNext()) {
                    Map.Entry it = (Map.Entry) minElem$iv;
                    long minValue$iv = ((AnimeIdMapping) it.getValue()).getTimestamp();
                    do {
                        Object e$iv = iterator$iv.next();
                        Map.Entry it2 = (Map.Entry) e$iv;
                        long v$iv = ((AnimeIdMapping) it2.getValue()).getTimestamp();
                        if (minValue$iv > v$iv) {
                            minElem$iv = e$iv;
                            minValue$iv = v$iv;
                        }
                    } while (iterator$iv.hasNext());
                }
            } else {
                minElem$iv = null;
            }
            Map.Entry oldest = (Map.Entry) minElem$iv;
            if (oldest != null) {
                animeIdCache.remove(oldest.getKey());
                Log.INSTANCE.d(TAG, "🗑️ Evicted oldest anime ID: " + ((String) oldest.getKey()));
            }
        }
        animeIdCache.put(key, mapping);
        Log.INSTANCE.d(TAG, "📦 Cached anime ID: " + key + " (cache size: " + animeIdCache.size() + ')');
    }

    /* JADX INFO: compiled from: StreamPlayCache.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001a¨\u0006&"}, d2 = {"Lcom/phisher98/StreamPlayCache$ProviderStats;", "", "successCount", "", "failureCount", "totalTimeMs", "", "lastExecutionMs", "consecutiveFailures", "<init>", "(IIJJI)V", "getSuccessCount", "()I", "getFailureCount", "getTotalTimeMs", "()J", "getLastExecutionMs", "getConsecutiveFailures", "successRate", "", "getSuccessRate", "()F", "avgTimeMs", "getAvgTimeMs", "isCircuitBroken", "", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ProviderStats {
        private final int consecutiveFailures;
        private final int failureCount;
        private final long lastExecutionMs;
        private final int successCount;
        private final long totalTimeMs;

        public ProviderStats() {
            this(0, 0, 0L, 0L, 0, 31, null);
        }

        public static /* synthetic */ ProviderStats copy$default(ProviderStats providerStats, int i, int i2, long j, long j2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = providerStats.successCount;
            }
            if ((i4 & 2) != 0) {
                i2 = providerStats.failureCount;
            }
            if ((i4 & 4) != 0) {
                j = providerStats.totalTimeMs;
            }
            if ((i4 & 8) != 0) {
                j2 = providerStats.lastExecutionMs;
            }
            if ((i4 & 16) != 0) {
                i3 = providerStats.consecutiveFailures;
            }
            int i5 = i3;
            long j3 = j2;
            return providerStats.copy(i, i2, j, j3, i5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSuccessCount() {
            return this.successCount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getFailureCount() {
            return this.failureCount;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getTotalTimeMs() {
            return this.totalTimeMs;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getLastExecutionMs() {
            return this.lastExecutionMs;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getConsecutiveFailures() {
            return this.consecutiveFailures;
        }

        @NotNull
        public final ProviderStats copy(int successCount, int failureCount, long totalTimeMs, long lastExecutionMs, int consecutiveFailures) {
            return new ProviderStats(successCount, failureCount, totalTimeMs, lastExecutionMs, consecutiveFailures);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProviderStats)) {
                return false;
            }
            ProviderStats providerStats = (ProviderStats) other;
            return this.successCount == providerStats.successCount && this.failureCount == providerStats.failureCount && this.totalTimeMs == providerStats.totalTimeMs && this.lastExecutionMs == providerStats.lastExecutionMs && this.consecutiveFailures == providerStats.consecutiveFailures;
        }

        public int hashCode() {
            return (((((((this.successCount * 31) + this.failureCount) * 31) + StreamPlayCache$ProviderStats$$ExternalSyntheticBackport0.m26m(this.totalTimeMs)) * 31) + StreamPlayCache$ProviderStats$$ExternalSyntheticBackport0.m26m(this.lastExecutionMs)) * 31) + this.consecutiveFailures;
        }

        @NotNull
        public String toString() {
            return "ProviderStats(successCount=" + this.successCount + ", failureCount=" + this.failureCount + ", totalTimeMs=" + this.totalTimeMs + ", lastExecutionMs=" + this.lastExecutionMs + ", consecutiveFailures=" + this.consecutiveFailures + ')';
        }

        public ProviderStats(int successCount, int failureCount, long totalTimeMs, long lastExecutionMs, int consecutiveFailures) {
            this.successCount = successCount;
            this.failureCount = failureCount;
            this.totalTimeMs = totalTimeMs;
            this.lastExecutionMs = lastExecutionMs;
            this.consecutiveFailures = consecutiveFailures;
        }

        public /* synthetic */ ProviderStats(int i, int i2, long j, long j2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0L : j, (i4 & 8) != 0 ? 0L : j2, (i4 & 16) != 0 ? 0 : i3);
        }

        public final int getSuccessCount() {
            return this.successCount;
        }

        public final int getFailureCount() {
            return this.failureCount;
        }

        public final long getTotalTimeMs() {
            return this.totalTimeMs;
        }

        public final long getLastExecutionMs() {
            return this.lastExecutionMs;
        }

        public final int getConsecutiveFailures() {
            return this.consecutiveFailures;
        }

        public final float getSuccessRate() {
            if (this.successCount + this.failureCount == 0) {
                return 0.0f;
            }
            return this.successCount / (this.successCount + this.failureCount);
        }

        public final long getAvgTimeMs() {
            if (this.successCount == 0) {
                return 0L;
            }
            return this.totalTimeMs / ((long) this.successCount);
        }

        public final boolean isCircuitBroken() {
            return this.consecutiveFailures >= 5;
        }
    }

    @NotNull
    public final ProviderStats getProviderStats(@NotNull String providerId) {
        ProviderStats providerStats = providerStatsMap.get(providerId);
        if (providerStats != null) {
            return providerStats;
        }
        return new ProviderStats(0, 0, 0L, 0L, 0, 31, null);
    }

    public final void recordProviderExecution(@NotNull String providerId, boolean success, long durationMs) {
        ProviderStats updated;
        ProviderStats providerStats = providerStatsMap.get(providerId);
        if (providerStats == null) {
            providerStats = new ProviderStats(0, 0, 0L, 0L, 0, 31, null);
        }
        ProviderStats current = providerStats;
        if (success) {
            updated = ProviderStats.copy$default(current, current.getSuccessCount() + 1, 0, current.getTotalTimeMs() + durationMs, durationMs, 0, 2, null);
        } else {
            updated = ProviderStats.copy$default(current, 0, current.getFailureCount() + 1, 0L, durationMs, current.getConsecutiveFailures() + 1, 5, null);
        }
        providerStatsMap.put(providerId, updated);
        if (updated.isCircuitBroken() && !current.isCircuitBroken()) {
            Log.INSTANCE.w(TAG, "📉 Provider moved to low priority: " + providerId + " (" + updated.getConsecutiveFailures() + " consecutive failures)");
        } else if (!updated.isCircuitBroken() && current.isCircuitBroken()) {
            Log.INSTANCE.d(TAG, "✅ Provider recovered: " + providerId);
        }
    }

    public final float getProviderPriorityScore(@NotNull String providerId) {
        ProviderStats stats = getProviderStats(providerId);
        if (stats.isCircuitBroken()) {
            return -1000.0f;
        }
        if (stats.getSuccessCount() + stats.getFailureCount() == 0) {
            return 0.0f;
        }
        float timePenalty = stats.getAvgTimeMs() > 0 ? stats.getAvgTimeMs() / 1000.0f : 0.0f;
        return (stats.getSuccessRate() * 100.0f) - timePenalty;
    }

    /* JADX INFO: compiled from: StreamPlayCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StreamPlayCache$MetadataCache;", "", "data", "", "timestamp", "", "<init>", "(Ljava/lang/String;J)V", "getData", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MetadataCache {

        @NotNull
        private final String data;
        private final long timestamp;

        public static /* synthetic */ MetadataCache copy$default(MetadataCache metadataCache, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = metadataCache.data;
            }
            if ((i & 2) != 0) {
                j = metadataCache.timestamp;
            }
            return metadataCache.copy(str, j);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        @NotNull
        public final MetadataCache copy(@NotNull String data, long timestamp) {
            return new MetadataCache(data, timestamp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MetadataCache)) {
                return false;
            }
            MetadataCache metadataCache = (MetadataCache) other;
            return Intrinsics.areEqual(this.data, metadataCache.data) && this.timestamp == metadataCache.timestamp;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + StreamPlayCache$MetadataCache$$ExternalSyntheticBackport0.m25m(this.timestamp);
        }

        @NotNull
        public String toString() {
            return "MetadataCache(data=" + this.data + ", timestamp=" + this.timestamp + ')';
        }

        public MetadataCache(@NotNull String data, long timestamp) {
            this.data = data;
            this.timestamp = timestamp;
        }

        public /* synthetic */ MetadataCache(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? System.currentTimeMillis() : j);
        }

        @NotNull
        public final String getData() {
            return this.data;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    @Nullable
    public final String getCachedMetadata(@NotNull String key) {
        MetadataCache cache = metadataCache.get(key);
        if (cache == null) {
            return null;
        }
        long age = System.currentTimeMillis() - cache.getTimestamp();
        if (age < METADATA_CACHE_TTL_MS) {
            Log.INSTANCE.d(TAG, "✅ Metadata cache hit: " + key);
            return cache.getData();
        }
        Log.INSTANCE.d(TAG, "⏰ Metadata cache expired: " + key);
        metadataCache.remove(key);
        return null;
    }

    public final void cacheMetadata(@NotNull String key, @NotNull String data) {
        Object minElem$iv;
        if (metadataCache.size() >= METADATA_CACHE_MAX_SIZE) {
            Iterable $this$minByOrNull$iv = metadataCache.entrySet();
            Iterator iterator$iv = $this$minByOrNull$iv.iterator();
            if (iterator$iv.hasNext()) {
                minElem$iv = iterator$iv.next();
                if (iterator$iv.hasNext()) {
                    Map.Entry it = (Map.Entry) minElem$iv;
                    long minValue$iv = ((MetadataCache) it.getValue()).getTimestamp();
                    do {
                        Object e$iv = iterator$iv.next();
                        Map.Entry it2 = (Map.Entry) e$iv;
                        long v$iv = ((MetadataCache) it2.getValue()).getTimestamp();
                        if (minValue$iv > v$iv) {
                            minElem$iv = e$iv;
                            minValue$iv = v$iv;
                        }
                    } while (iterator$iv.hasNext());
                }
            } else {
                minElem$iv = null;
            }
            Map.Entry oldest = (Map.Entry) minElem$iv;
            if (oldest != null) {
                metadataCache.remove(oldest.getKey());
                Log.INSTANCE.d(TAG, "🗑️ Evicted oldest metadata: " + ((String) oldest.getKey()));
            }
        }
        metadataCache.put(key, new MetadataCache(data, 0L, 2, null));
        Log.INSTANCE.d(TAG, "📦 Cached metadata: " + key + " (cache size: " + metadataCache.size() + ')');
    }

    public final void saveProviderStats(@Nullable SharedPreferences prefs) {
        SharedPreferences.Editor $this$saveProviderStats_u24lambda_u240;
        if (prefs != null && ($this$saveProviderStats_u24lambda_u240 = prefs.edit()) != null) {
            Map $this$forEach$iv = providerStatsMap;
            for (Map.Entry<String, ProviderStats> entry : $this$forEach$iv.entrySet()) {
                String providerId = entry.getKey();
                ProviderStats stats = entry.getValue();
                $this$saveProviderStats_u24lambda_u240.putString("provider_stats_" + providerId, new StringBuilder().append(stats.getSuccessCount()).append(',').append(stats.getFailureCount()).append(',').append(stats.getTotalTimeMs()).append(',').append(stats.getConsecutiveFailures()).toString());
            }
            $this$saveProviderStats_u24lambda_u240.apply();
        }
    }

    public final void loadProviderStats(@Nullable SharedPreferences prefs) {
        Map<String, ?> all;
        if (prefs != null && (all = prefs.getAll()) != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (StringsKt.startsWith$default(key, "provider_stats_", false, 2, (Object) null) && (value instanceof String)) {
                    String providerId = StringsKt.removePrefix(key, "provider_stats_");
                    List parts = StringsKt.split$default((CharSequence) value, new String[]{","}, false, 0, 6, (Object) null);
                    if (parts.size() >= 4) {
                        try {
                            ProviderStats stats = new ProviderStats(Integer.parseInt((String) parts.get(0)), Integer.parseInt((String) parts.get(1)), Long.parseLong((String) parts.get(2)), 0L, Integer.parseInt((String) parts.get(3)), 8, null);
                            providerStatsMap.put(providerId, stats);
                        } catch (Exception e) {
                            Log.INSTANCE.e(TAG, "Error loading stats for " + providerId + ": " + e.getMessage());
                        }
                    }
                }
            }
        }
        Log.INSTANCE.d(TAG, "📂 Loaded provider stats from SharedPreferences (" + providerStatsMap.size() + " providers)");
    }
}
