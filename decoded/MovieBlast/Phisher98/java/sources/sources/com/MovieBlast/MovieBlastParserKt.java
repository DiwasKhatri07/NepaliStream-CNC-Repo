package com.MovieBlast;

import com.lagradost.cloudstream3.MainAPIKt;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MovieBlastParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieBlast/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"generateSignedUrl", "", "url", "MovieBlast"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class MovieBlastParserKt {
    @NotNull
    public static final String generateSignedUrl(@NotNull String url) {
        try {
            String path = new URL(url).getPath();
            String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
            String secret = MainAPIKt.base64Decode("R0o4cmV5ZGFySTdKcWF0OXJ2YkFKS05ROWdZNERvRVFGMkg1bmZ1STFnaQ==");
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = secret.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            SecretKeySpec key = new SecretKeySpec(bytes, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(key);
            byte[] bytes2 = (path + timestamp).getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            byte[] hash = mac.doFinal(bytes2);
            String signature = MainAPIKt.base64Encode(hash);
            return url + "?verify=" + timestamp + '-' + URLEncoder.encode(signature, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException("Error generating HMAC", e);
        }
    }
}
