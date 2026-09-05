package com.phisher98;

import android.content.Context;
import com.lagradost.api.Log;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okio.BufferedSource;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/phisher98/UltimaPlugin$startSseListener$1$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUltimaPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaPlugin.kt\ncom/phisher98/UltimaPlugin$startSseListener$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,866:1\n1#2:867\n*E\n"})
public final class UltimaPlugin$startSseListener$1$1 implements Callback {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ UltimaPlugin this$0;

    UltimaPlugin$startSseListener$1$1(UltimaPlugin $receiver, Context $appContext) {
        this.this$0 = $receiver;
        this.$appContext = $appContext;
    }

    public void onFailure(Call call, IOException e) {
        Object obj = this.this$0.sseLock;
        UltimaPlugin ultimaPlugin = this.this$0;
        synchronized (obj) {
            if (ultimaPlugin.sseCall != call) {
                return;
            }
            ultimaPlugin.isSseConnected = false;
            ultimaPlugin.sseCall = null;
            ultimaPlugin.sseRetryCount++;
            if (call.isCanceled()) {
                return;
            }
            long backoffMs = this.this$0.calculateSseBackoff();
            Log.INSTANCE.e("UltimaSync", "SSE connection failed: " + e.getMessage() + ", reconnecting in " + backoffMs + "ms");
            BuildersKt.launch$default(this.this$0.pluginScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaPlugin$startSseListener$1$1$onFailure$2(backoffMs, this.this$0, this.$appContext, null), 3, (Object) null);
        }
    }

    public void onResponse(Call call, Response response) {
        CoroutineScope coroutineScope;
        UltimaPlugin$startSseListener$1$1$onResponse$9 ultimaPlugin$startSseListener$1$1$onResponse$9;
        CoroutineStart coroutineStart;
        String line;
        Object obj = this.this$0.sseLock;
        UltimaPlugin ultimaPlugin = this.this$0;
        synchronized (obj) {
            if (ultimaPlugin.sseCall != call) {
                response.close();
                return;
            }
            Unit unit = Unit.INSTANCE;
            int iCode = response.code();
            UltimaPlugin ultimaPlugin2 = this.this$0;
            if (iCode != 200) {
                Object obj2 = ultimaPlugin2.sseLock;
                UltimaPlugin ultimaPlugin3 = this.this$0;
                synchronized (obj2) {
                    if (ultimaPlugin3.sseCall != call) {
                        response.close();
                        return;
                    }
                    ultimaPlugin3.isSseConnected = false;
                    ultimaPlugin3.sseCall = null;
                    ultimaPlugin3.sseRetryCount++;
                    response.close();
                    long backoffMs = this.this$0.calculateSseBackoff();
                    Log.INSTANCE.e("UltimaSync", "SSE connection failed with HTTP code " + response.code() + ", reconnecting in " + backoffMs + "ms");
                    BuildersKt.launch$default(this.this$0.pluginScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaPlugin$startSseListener$1$1$onResponse$3(backoffMs, this.this$0, this.$appContext, null), 3, (Object) null);
                    return;
                }
            }
            Object obj3 = ultimaPlugin2.sseLock;
            UltimaPlugin ultimaPlugin4 = this.this$0;
            synchronized (obj3) {
                if (ultimaPlugin4.sseCall != call) {
                    response.close();
                    return;
                }
                ultimaPlugin4.isSseConnected = true;
                ultimaPlugin4.sseRetryCount = 0;
                Unit unit2 = Unit.INSTANCE;
                BufferedSource source = response.body().source();
                String currentEvent = null;
                while (true) {
                    try {
                        try {
                            Object obj4 = this.this$0.sseLock;
                            UltimaPlugin ultimaPlugin5 = this.this$0;
                            synchronized (obj4) {
                                if (ultimaPlugin5.sseCall != call) {
                                    response.close();
                                    boolean shouldRetry = false;
                                    Object obj5 = this.this$0.sseLock;
                                    UltimaPlugin ultimaPlugin6 = this.this$0;
                                    synchronized (obj5) {
                                        if (ultimaPlugin6.sseCall == call) {
                                            ultimaPlugin6.isSseConnected = false;
                                            ultimaPlugin6.sseCall = null;
                                            if (!call.isCanceled()) {
                                                ultimaPlugin6.sseRetryCount++;
                                                shouldRetry = true;
                                            }
                                        }
                                        Unit unit3 = Unit.INSTANCE;
                                    }
                                    if (shouldRetry) {
                                        long backoffMs2 = this.this$0.calculateSseBackoff();
                                        BuildersKt.launch$default(this.this$0.pluginScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaPlugin$startSseListener$1$1$onResponse$9(backoffMs2, this.this$0, this.$appContext, null), 3, (Object) null);
                                        return;
                                    }
                                    return;
                                }
                                Unit unit4 = Unit.INSTANCE;
                                if (!source.exhausted() && (line = source.readUtf8Line()) != null) {
                                    if (StringsKt.isBlank(line)) {
                                        currentEvent = null;
                                    } else if (StringsKt.startsWith$default(line, "event:", false, 2, (Object) null)) {
                                        String strSubstring = line.substring(6);
                                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                        currentEvent = StringsKt.trim(strSubstring).toString();
                                    } else if (StringsKt.startsWith$default(line, "data:", false, 2, (Object) null) && (Intrinsics.areEqual(currentEvent, "put") || Intrinsics.areEqual(currentEvent, "patch"))) {
                                        String strSubstring2 = line.substring(5);
                                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                                        String json = StringsKt.trim(strSubstring2).toString();
                                        if (!Intrinsics.areEqual(json, "null")) {
                                            if (json.length() > 0) {
                                                long timeSinceLastPush = System.currentTimeMillis() - this.this$0.lastPushTimestamp;
                                                if (timeSinceLastPush < 5000) {
                                                    Log.INSTANCE.d("UltimaSync", "SSE: Ignoring event within " + timeSinceLastPush + "ms of our own push");
                                                } else {
                                                    Runnable it = this.this$0.ssePullRunnable;
                                                    if (it != null) {
                                                        this.this$0.mainHandler.removeCallbacks(it);
                                                    }
                                                    final UltimaPlugin ultimaPlugin7 = this.this$0;
                                                    final Context context = this.$appContext;
                                                    Runnable pullRunnable = new Runnable() { // from class: com.phisher98.UltimaPlugin$startSseListener$1$1$$ExternalSyntheticLambda0
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            UltimaPlugin ultimaPlugin8 = ultimaPlugin7;
                                                            BuildersKt.launch$default(ultimaPlugin8.pluginScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaPlugin$startSseListener$1$1$onResponse$pullRunnable$1$1(ultimaPlugin8, context, null), 3, (Object) null);
                                                        }
                                                    };
                                                    this.this$0.ssePullRunnable = pullRunnable;
                                                    this.this$0.mainHandler.postDelayed(pullRunnable, 3000L);
                                                }
                                            }
                                        }
                                        currentEvent = null;
                                    }
                                }
                                response.close();
                                boolean shouldRetry2 = false;
                                Object obj6 = this.this$0.sseLock;
                                UltimaPlugin ultimaPlugin8 = this.this$0;
                                synchronized (obj6) {
                                    if (ultimaPlugin8.sseCall == call) {
                                        ultimaPlugin8.isSseConnected = false;
                                        ultimaPlugin8.sseCall = null;
                                        if (!call.isCanceled()) {
                                            ultimaPlugin8.sseRetryCount++;
                                            shouldRetry2 = true;
                                        }
                                    }
                                    Unit unit5 = Unit.INSTANCE;
                                }
                                if (shouldRetry2) {
                                    long backoffMs3 = this.this$0.calculateSseBackoff();
                                    coroutineScope = this.this$0.pluginScope;
                                    coroutineStart = null;
                                    ultimaPlugin$startSseListener$1$1$onResponse$9 = new UltimaPlugin$startSseListener$1$1$onResponse$9(backoffMs3, this.this$0, this.$appContext, null);
                                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, coroutineStart, ultimaPlugin$startSseListener$1$1$onResponse$9, 3, (Object) null);
                                    return;
                                }
                                return;
                            }
                        } catch (Exception e) {
                            Object obj7 = this.this$0.sseLock;
                            UltimaPlugin ultimaPlugin9 = this.this$0;
                            synchronized (obj7) {
                                if (ultimaPlugin9.sseCall == call) {
                                    ultimaPlugin9.isSseConnected = false;
                                }
                                Unit unit6 = Unit.INSTANCE;
                                if (!call.isCanceled()) {
                                    Log.INSTANCE.e("UltimaSync", "SSE read error: " + e.getMessage());
                                }
                                response.close();
                                boolean shouldRetry3 = false;
                                Object obj8 = this.this$0.sseLock;
                                UltimaPlugin ultimaPlugin10 = this.this$0;
                                synchronized (obj8) {
                                    if (ultimaPlugin10.sseCall == call) {
                                        ultimaPlugin10.isSseConnected = false;
                                        ultimaPlugin10.sseCall = null;
                                        if (!call.isCanceled()) {
                                            ultimaPlugin10.sseRetryCount++;
                                            shouldRetry3 = true;
                                        }
                                    }
                                    Unit unit7 = Unit.INSTANCE;
                                    if (!shouldRetry3) {
                                        return;
                                    }
                                    long backoffMs4 = this.this$0.calculateSseBackoff();
                                    coroutineScope = this.this$0.pluginScope;
                                    coroutineStart = null;
                                    ultimaPlugin$startSseListener$1$1$onResponse$9 = new UltimaPlugin$startSseListener$1$1$onResponse$9(backoffMs4, this.this$0, this.$appContext, null);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        response.close();
                        boolean shouldRetry4 = false;
                        Object obj9 = this.this$0.sseLock;
                        UltimaPlugin ultimaPlugin11 = this.this$0;
                        synchronized (obj9) {
                            if (ultimaPlugin11.sseCall == call) {
                                ultimaPlugin11.isSseConnected = false;
                                ultimaPlugin11.sseCall = null;
                                if (!call.isCanceled()) {
                                    ultimaPlugin11.sseRetryCount++;
                                    shouldRetry4 = true;
                                }
                            }
                            Unit unit8 = Unit.INSTANCE;
                            if (shouldRetry4) {
                                long backoffMs5 = this.this$0.calculateSseBackoff();
                                BuildersKt.launch$default(this.this$0.pluginScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaPlugin$startSseListener$1$1$onResponse$9(backoffMs5, this.this$0, this.$appContext, null), 3, (Object) null);
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }
}
