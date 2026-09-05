package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/phisher98/ResponseHash;", "", "embed_url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "key", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmbed_url", "()Ljava/lang/String;", "getKey", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ResponseHash {

    @NotNull
    private final String embed_url;

    @Nullable
    private final String key;

    @Nullable
    private final String type;

    public static /* synthetic */ ResponseHash copy$default(ResponseHash responseHash, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = responseHash.embed_url;
        }
        if ((i & 2) != 0) {
            str2 = responseHash.key;
        }
        if ((i & 4) != 0) {
            str3 = responseHash.type;
        }
        return responseHash.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmbed_url() {
        return this.embed_url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final ResponseHash copy(@JsonProperty("embed_url") @NotNull String embed_url, @JsonProperty("key") @Nullable String key, @JsonProperty("type") @Nullable String type) {
        return new ResponseHash(embed_url, key, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseHash)) {
            return false;
        }
        ResponseHash responseHash = (ResponseHash) other;
        return Intrinsics.areEqual(this.embed_url, responseHash.embed_url) && Intrinsics.areEqual(this.key, responseHash.key) && Intrinsics.areEqual(this.type, responseHash.type);
    }

    public int hashCode() {
        return (((this.embed_url.hashCode() * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ResponseHash(embed_url=" + this.embed_url + ", key=" + this.key + ", type=" + this.type + ')';
    }

    public ResponseHash(@JsonProperty("embed_url") @NotNull String embed_url, @JsonProperty("key") @Nullable String key, @JsonProperty("type") @Nullable String type) {
        this.embed_url = embed_url;
        this.key = key;
        this.type = type;
    }

    public /* synthetic */ ResponseHash(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @NotNull
    public final String getEmbed_url() {
        return this.embed_url;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }
}
