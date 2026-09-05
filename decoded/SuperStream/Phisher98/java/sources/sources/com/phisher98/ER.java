package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SuperStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0090\u0001\u0010!\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/phisher98/ER;", "", "code", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "msg", "", "serverRuntime", "", "server_runtime", "serverName", "server_name", "data", "Lcom/phisher98/DData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lcom/phisher98/DData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "getServerRuntime", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getServerName", "getData", "()Lcom/phisher98/DData;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Lcom/phisher98/DData;)Lcom/phisher98/ER;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ER {

    @Nullable
    private final Integer code;

    @Nullable
    private final DData data;

    @Nullable
    private final String msg;

    @Nullable
    private final String serverName;

    @Nullable
    private final Double serverRuntime;

    public ER() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ER copy$default(ER er, Integer num, String str, Double d, String str2, DData dData, int i, Object obj) {
        if ((i & 1) != 0) {
            num = er.code;
        }
        if ((i & 2) != 0) {
            str = er.msg;
        }
        if ((i & 4) != 0) {
            d = er.serverRuntime;
        }
        if ((i & 8) != 0) {
            str2 = er.serverName;
        }
        if ((i & 16) != 0) {
            dData = er.data;
        }
        DData dData2 = dData;
        Double d2 = d;
        return er.copy(num, str, d2, str2, dData2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getServerRuntime() {
        return this.serverRuntime;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getServerName() {
        return this.serverName;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DData getData() {
        return this.data;
    }

    @NotNull
    public final ER copy(@JsonProperty("code") @Nullable Integer code, @JsonProperty("msg") @Nullable String msg, @JsonProperty("server_runtime") @Nullable Double serverRuntime, @JsonProperty("server_name") @Nullable String serverName, @JsonProperty("data") @Nullable DData data) {
        return new ER(code, msg, serverRuntime, serverName, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ER)) {
            return false;
        }
        ER er = (ER) other;
        return Intrinsics.areEqual(this.code, er.code) && Intrinsics.areEqual(this.msg, er.msg) && Intrinsics.areEqual(this.serverRuntime, er.serverRuntime) && Intrinsics.areEqual(this.serverName, er.serverName) && Intrinsics.areEqual(this.data, er.data);
    }

    public int hashCode() {
        return ((((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.msg == null ? 0 : this.msg.hashCode())) * 31) + (this.serverRuntime == null ? 0 : this.serverRuntime.hashCode())) * 31) + (this.serverName == null ? 0 : this.serverName.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ER(code=" + this.code + ", msg=" + this.msg + ", serverRuntime=" + this.serverRuntime + ", serverName=" + this.serverName + ", data=" + this.data + ')';
    }

    public ER(@JsonProperty("code") @Nullable Integer code, @JsonProperty("msg") @Nullable String msg, @JsonProperty("server_runtime") @Nullable Double serverRuntime, @JsonProperty("server_name") @Nullable String serverName, @JsonProperty("data") @Nullable DData data) {
        this.code = code;
        this.msg = msg;
        this.serverRuntime = serverRuntime;
        this.serverName = serverName;
        this.data = data;
    }

    public /* synthetic */ ER(Integer num, String str, Double d, String str2, DData dData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : dData);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final Double getServerRuntime() {
        return this.serverRuntime;
    }

    @Nullable
    public final String getServerName() {
        return this.serverName;
    }

    @Nullable
    public final DData getData() {
        return this.data;
    }
}
