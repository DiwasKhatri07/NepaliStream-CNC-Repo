package com.MPlayer;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"JSONParser", "Lcom/lagradost/nicehttp/ResponseParser;", "getJSONParser", "()Lcom/lagradost/nicehttp/ResponseParser;", "app", "Lcom/lagradost/nicehttp/Requests;", "getApp", "()Lcom/lagradost/nicehttp/Requests;", "MPlayerProvider"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class UtilsKt {

    @NotNull
    private static final ResponseParser JSONParser = new ResponseParser() { // from class: com.MPlayer.UtilsKt$JSONParser$1
        private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);

        public final ObjectMapper getMapper() {
            return this.mapper;
        }

        public <T> T parse(String text, KClass<T> kClass) {
            return (T) this.mapper.readValue(text, JvmClassMappingKt.getJavaClass(kClass));
        }

        public <T> T parseSafe(String text, KClass<T> kClass) {
            try {
                return (T) this.mapper.readValue(text, JvmClassMappingKt.getJavaClass(kClass));
            } catch (Exception e) {
                return null;
            }
        }

        public String writeValueAsString(Object obj) {
            return this.mapper.writeValueAsString(obj);
        }
    };

    @NotNull
    private static final Requests app;

    static {
        Requests $this$app_u24lambda_u240 = new Requests((OkHttpClient) null, (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, JSONParser, 255, (DefaultConstructorMarker) null);
        $this$app_u24lambda_u240.setDefaultHeaders(MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36")));
        app = $this$app_u24lambda_u240;
    }

    @NotNull
    public static final ResponseParser getJSONParser() {
        return JSONParser;
    }

    @NotNull
    public static final Requests getApp() {
        return app;
    }
}
