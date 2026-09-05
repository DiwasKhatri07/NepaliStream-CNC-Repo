package com.phisher98;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.lagradost.nicehttp.Session;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"session", "Lcom/lagradost/nicehttp/Session;", "getSession", "()Lcom/lagradost/nicehttp/Session;", "webMutex", "Lkotlinx/coroutines/sync/Mutex;", "getWebMutex", "()Lkotlinx/coroutines/sync/Mutex;", "streamPlayExtractorMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getStreamPlayExtractorMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "streamPlayExtractorMapper$delegate", "Lkotlin/Lazy;", "normalizeAlphaNumSpaceRegex", "Lkotlin/text/Regex;", "normalizeAlphaNumRegex", "StreamPlay"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class StreamPlayExtractorKt {

    @NotNull
    private static final Session session = new Session(new Requests((OkHttpClient) null, (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0, (ResponseParser) null, 511, (DefaultConstructorMarker) null).getBaseClient());

    @NotNull
    private static final Mutex webMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private static final Lazy streamPlayExtractorMapper$delegate = LazyKt.lazy(new Function0() { // from class: com.phisher98.StreamPlayExtractorKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            return ExtensionsKt.jacksonObjectMapper();
        }
    });

    @NotNull
    private static final Regex normalizeAlphaNumSpaceRegex = new Regex("[^a-z0-9 ]");

    @NotNull
    private static final Regex normalizeAlphaNumRegex = new Regex("[^a-z0-9]");

    @NotNull
    public static final Session getSession() {
        return session;
    }

    @NotNull
    public static final Mutex getWebMutex() {
        return webMutex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObjectMapper getStreamPlayExtractorMapper() {
        return (ObjectMapper) streamPlayExtractorMapper$delegate.getValue();
    }
}
